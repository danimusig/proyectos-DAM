import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { User } from './user/user';
import { Login } from './login/login';
import { Lists } from './lists/lists';

@Component({
  imports: [RouterOutlet, User, Login, Lists],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('task-manager');
}
