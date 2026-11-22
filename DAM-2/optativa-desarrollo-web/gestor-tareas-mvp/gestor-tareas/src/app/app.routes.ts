import { Routes } from '@angular/router';
import { Tasks } from './features/tasks/tasks';
import { Stats } from './features/stats/stats';

export const routes: Routes = [
  { path: '', redirectTo: 'tareas', pathMatch: 'full' },
  { path: 'tareas', component: Tasks, title: 'Mis Tareas' },
  { path: 'estadisticas', component: Stats, title: 'Estadísticas' },
  { path: '**', redirectTo: 'tareas' },
];