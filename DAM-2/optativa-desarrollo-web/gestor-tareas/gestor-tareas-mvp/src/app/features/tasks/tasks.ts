import { Component, inject, signal, computed } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
import { MatDatepickerModule, MatCalendarCellCssClasses } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatTooltipModule } from '@angular/material/tooltip';
import { TaskService } from '../../services/tasks';
import { Task, TaskPriority } from '../../models/task.model';

@Component({
  selector: 'app-tasks',
  providers: [provideNativeDateAdapter()],
  imports: [
    ReactiveFormsModule,
    MatCardModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule,
    MatTooltipModule,
  ],
  templateUrl: './tasks.html',
  styleUrl: './tasks.scss',
})
export class Tasks {
  private readonly fb = inject(FormBuilder);
  protected readonly taskService = inject(TaskService);

  // Calendar & filter state
  protected readonly selectedDate = signal<Date>(new Date());
  protected readonly showAllTasks = signal<boolean>(false);
  protected readonly editingTaskId = signal<string | null>(null);

  // ISO string ('YYYY-MM-DD') derived automatically from the calendar Date
  protected readonly selectedDateIso = computed(() =>
    this.formatDateToIso(this.selectedDate())
  );

  // Reactive task list: filters by selected date (unless "Show All" is active)
  // and sorts incomplete tasks first, then by priority
  protected readonly filteredTasks = computed(() => {
    const allTasks = this.taskService.tasks();
    const targetDate = this.selectedDateIso();

    const list = this.showAllTasks()
      ? allTasks
      : allTasks.filter((t) => t.dueDate === targetDate);

    const priorityWeight: Record<TaskPriority, number> = {
      high: 3,
      medium: 2,
      low: 1,
    };

    return [...list].sort((a, b) => {
      if (a.completed !== b.completed) {
        return Number(a.completed) - Number(b.completed);
      }
      return priorityWeight[b.priority] - priorityWeight[a.priority];
    });
  });

  // Strongly typed form used for both creating and editing tasks
  protected readonly taskForm = this.fb.nonNullable.group({
    title: ['', [Validators.required, Validators.minLength(2)]],
    description: [''],
    dueDate: [this.formatDateToIso(new Date()), Validators.required],
    priority: ['medium' as TaskPriority, Validators.required],
  });

  // Highlights calendar days that have at least one task
  protected readonly dateClass = (cellDate: Date): MatCalendarCellCssClasses => {
    const iso = this.formatDateToIso(cellDate);
    const hasTask = this.taskService.tasks().some((t) => t.dueDate === iso);
    return hasTask ? 'has-tasks-dot' : '';
  };

  protected onDateSelected(date: Date | null): void {
    if (!date) return;
    this.selectedDate.set(date);
    this.showAllTasks.set(false);

    // If creating a new task, automatically update the form's due date to the clicked day
    if (!this.editingTaskId()) {
      this.taskForm.patchValue({ dueDate: this.formatDateToIso(date) });
    }
  }

  protected onSubmit(): void {
    if (this.taskForm.invalid) return;

    const formValue = this.taskForm.getRawValue();
    const editId = this.editingTaskId();

    if (editId) {
      const existing = this.taskService.tasks().find((t) => t.id === editId);
      if (existing) {
        this.taskService.updateTask({
          ...existing,
          ...formValue,
        });
      }
      this.cancelEdit();
    } else {
      this.taskService.addTask({
        ...formValue,
        completed: false,
      });
      this.resetFormToSelectedDate();
    }
  }

  protected startEdit(task: Task): void {
    this.editingTaskId.set(task.id);
    this.taskForm.patchValue({
      title: task.title,
      description: task.description ?? '',
      dueDate: task.dueDate,
      priority: task.priority,
    });
  }

  protected cancelEdit(): void {
    this.editingTaskId.set(null);
    this.resetFormToSelectedDate();
  }

  protected getPriorityLabel(priority: TaskPriority): string {
    const labels: Record<TaskPriority, string> = {
      high: 'Alta',
      medium: 'Media',
      low: 'Baja',
    };
    return labels[priority];
  }

  private resetFormToSelectedDate(): void {
    this.taskForm.reset({
      title: '',
      description: '',
      dueDate: this.selectedDateIso(),
      priority: 'medium',
    });
  }

  private formatDateToIso(date: Date): string {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  }
}