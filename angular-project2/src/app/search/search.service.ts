import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private _url: string ='http://localhost:8080/name-and-game/game/search/zelda';
  search: string = '';

  constructor(private http: HttpClient) { }

  getGames () {
    this._url = `this._url${this.search}`;
    return this.http.get(this._url);
  }
}
