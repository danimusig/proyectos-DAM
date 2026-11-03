import { Component, EventEmitter, input, output } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-games',
  styles: ``,
  template: ` 
    <h3>Los juegos favoritos de {{ username() }}</h3>
    <ul>
      @for (game of games; track game.id) {
        <li (click)="addFav(game.name)">{{ game.name }}</li>
      }
    </ul> 
  `,
})

export class Games {
  username = input('');
  favGame = output<string>()

  addFav(gameName: string) {
    this.favGame.emit(gameName)
  }

  games = [
    {
      id: 1,
      name: 'Crash Bandicoot'
    },
    {
      id: 2,
      name: 'Heroes Of Might And Magic III'
    },
    {
      id: 3,
      name: 'Deadlock'
    }
  ]
}
