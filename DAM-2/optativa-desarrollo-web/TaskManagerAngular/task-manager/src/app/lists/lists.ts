import { Component, input } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-lists',
  styleUrl: './lists.css',
  templateUrl: './lists.html',
})

export class Lists {
  nombrelista = input()
}

