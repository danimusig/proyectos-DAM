export type TaskPriority = 'low' | 'medium' | 'high';

export interface Task {
  id: string;              // Local UUID in MVP; maps to SQLite TEXT/INTEGER ID later
  title: string;
  description?: string;
  dueDate: string;         // Format: 'YYYY-MM-DD'
  completed: boolean;      // Maps to SQLite INTEGER (0 or 1)
  priority: TaskPriority;
  createdAt: string;
}