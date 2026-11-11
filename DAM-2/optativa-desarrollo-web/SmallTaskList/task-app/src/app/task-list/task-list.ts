import { Component, input } from '@angular/core';
import { TaskService } from '../task';

@Component({
  selector: 'app-task-list',
  styleUrl: './task-list.css',
  templateUrl: './task-list.html',
})
export class TaskList {
  newTitle = '';

  constructor(public taskService: TaskService) {
    this.taskService.load()
  }

  addTask() {
    if (this.newTitle.trim()) {
      this.taskService.add(this.newTitle);
      this.newTitle = '';
    }
  }
}
