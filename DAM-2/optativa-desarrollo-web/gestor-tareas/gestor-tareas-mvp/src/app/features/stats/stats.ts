import { Component, inject, computed } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { TaskService } from '../../services/tasks';
import { TaskPriority } from '../../models/task.model';

interface PriorityStatRow {
  key: TaskPriority;
  label: string;
  total: number;
  completed: number;
  sharePercent: number;
  cssClass: string;
}

interface DailyBar {
  isoDate: string;
  shortLabel: string;
  count: number;
  completedCount: number;
  heightPercent: number;
  isToday: boolean;
}

@Component({
  selector: 'app-stats',
  imports: [
    RouterLink,
    MatCardModule,
    MatProgressBarModule,
    MatIconModule,
    MatButtonModule,
  ],
  templateUrl: './stats.html',
  styleUrl: './stats.scss',
})
export class Stats {
  protected readonly taskService = inject(TaskService);
  protected readonly stats = this.taskService.stats;

  // Tasks whose dueDate is before today and are still pending
  protected readonly overdueCount = computed(() => {
    const today = this.formatDateToIso(new Date());
    return this.taskService
      .tasks()
      .filter((t) => !t.completed && t.dueDate < today).length;
  });

  // Breakdown by priority with percentage of total workload
  protected readonly priorityRows = computed<PriorityStatRow[]>(() => {
    const all = this.taskService.tasks();
    const total = all.length;

    const config: { key: TaskPriority; label: string; cssClass: string }[] = [
      { key: 'high', label: 'Alta', cssClass: 'bar-high' },
      { key: 'medium', label: 'Media', cssClass: 'bar-medium' },
      { key: 'low', label: 'Baja', cssClass: 'bar-low' },
    ];

    return config.map(({ key, label, cssClass }) => {
      const matching = all.filter((t) => t.priority === key);
      const count = matching.length;
      const completed = matching.filter((t) => t.completed).length;
      const sharePercent = total > 0 ? Math.round((count / total) * 100) : 0;

      return { key, label, total: count, completed, sharePercent, cssClass };
    });
  });

  // 7-day workload bar chart (Today + next 6 days)
  protected readonly weeklyBars = computed<DailyBar[]>(() => {
    const all = this.taskService.tasks();
    const days: { isoDate: string; shortLabel: string; count: number; completedCount: number; isToday: boolean }[] = [];
    const dayNames = ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'];

    for (let offset = 0; offset < 7; offset++) {
      const date = new Date();
      date.setDate(date.getDate() + offset);
      const isoDate = this.formatDateToIso(date);
      const tasksForDay = all.filter((t) => t.dueDate === isoDate);

      days.push({
        isoDate,
        shortLabel: offset === 0 ? 'Hoy' : `${dayNames[date.getDay()]} ${date.getDate()}`,
        count: tasksForDay.length,
        completedCount: tasksForDay.filter((t) => t.completed).length,
        isToday: offset === 0,
      });
    }

    const maxCount = Math.max(...days.map((d) => d.count), 1);

    return days.map((d) => ({
      ...d,
      heightPercent: Math.round((d.count / maxCount) * 100),
    }));
  });

  private formatDateToIso(date: Date): string {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  }
}