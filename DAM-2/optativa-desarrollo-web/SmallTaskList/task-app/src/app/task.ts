import { Service } from '@angular/core';
import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http'

@Service()
export class Task {}


@Injectable ({ providedIn: 'root'})
export class TaskService {
    tasks: any[] = [];

    constructor(private http: HttpClient) {}

    load() {
        this.http.get('https://example.com/api/tasks')
        .subscribe(data => this.tasks = data as any[]);
    }

    add(title: string) {
        this.tasks.push({title, done: false});
    }
}
