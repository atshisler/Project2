import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Game } from './game'

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private _url: string ='http://localhost:8080/name-and-game/test/game';

  constructor(private http: HttpClient) { }

  getGames () {
    return this.http.get(this._url);
  }
}
