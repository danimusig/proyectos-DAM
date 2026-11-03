import { Component } from '@angular/core';
import { Games } from '../games/games';

@Component({
  imports: [Games],
  selector: 'app-user',
  styleUrl: './user.css',
  templateUrl: './user.html',
})

export class User {
  username = 'Danidev';
  isLoggedIn = false;
  userFavGame = ''

  getFavorite(gameName: string) {
    this.userFavGame = gameName;
  }

  greet() {
    alert('Hola!!!');
  }
}
