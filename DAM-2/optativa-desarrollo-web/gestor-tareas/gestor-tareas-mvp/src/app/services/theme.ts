import { Injectable, signal, effect } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {
  readonly isDarkMode = signal<boolean>(this.loadInitialTheme());

  constructor() {
    effect(() => {
      const dark = this.isDarkMode();
      document.documentElement.classList.toggle('dark-theme', dark);
      localStorage.setItem('theme', dark ? 'dark' : 'light');
    });
  }

  toggleTheme(): void {
    this.isDarkMode.update((current) => !current);
  }

  private loadInitialTheme(): boolean {
    const saved = localStorage.getItem('theme');
    if (saved) return saved === 'dark';
    return window.matchMedia('(prefers-color-scheme: dark)').matches;
  }
}