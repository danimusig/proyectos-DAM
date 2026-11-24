import { Injectable, signal, computed } from '@angular/core';
import { Task } from '../models/task.model';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private readonly STORAGE_KEY = 'mvp_tasks_v1';

  // Writable internal state + read-only public signal
  private readonly tasksState = signal<Task[]>(this.loadFromStorage());
  readonly tasks = this.tasksState.asReadonly();

  // Derived statistics: recalculates automatically whenever tasksState changes
  readonly stats = computed(() => {
    const all = this.tasksState();
    const total = all.length;
    const completed = all.filter((t) => t.completed).length;
    const pending = total - completed;
    const completionRate = total > 0 ? Math.round((completed / total) * 100) : 0;

    const byPriority = {
      high: all.filter((t) => t.priority === 'high').length,
      medium: all.filter((t) => t.priority === 'medium').length,
      low: all.filter((t) => t.priority === 'low').length,
    };

    return { total, completed, pending, completionRate, byPriority };
  });

  // --- CRUD Operations (ready to swap for HttpClient + PHP endpoints later) ---

  addTask(taskData: Omit<Task, 'id' | 'createdAt'>): void {
    const newTask: Task = {
      ...taskData,
      id: crypto.randomUUID(),
      createdAt: new Date().toISOString(),
    };
    this.saveState([...this.tasksState(), newTask]);
  }

  updateTask(updatedTask: Task): void {
    const updatedList = this.tasksState().map((t) =>
      t.id === updatedTask.id ? updatedTask : t
    );
    this.saveState(updatedList);
  }

  toggleTaskCompletion(id: string): void {
    const updatedList = this.tasksState().map((t) =>
      t.id === id ? { ...t, completed: !t.completed } : t
    );
    this.saveState(updatedList);
  }

  deleteTask(id: string): void {
    const filtered = this.tasksState().filter((t) => t.id !== id);
    this.saveState(filtered);
  }

  // --- Persistence Layer (only section you will replace when adding PHP) ---

  private saveState(tasks: Task[]): void {
    this.tasksState.set(tasks);
    localStorage.setItem(this.STORAGE_KEY, JSON.stringify(tasks));
  }

  private loadFromStorage(): Task[] {
    const raw = localStorage.getItem(this.STORAGE_KEY);
    return raw ? JSON.parse(raw) : [];
  }
}