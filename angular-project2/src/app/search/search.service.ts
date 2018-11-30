import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private _url: string ='http://ec2-3-16-11-92.us-east-2.compute.amazonaws.com:8080/name-and-game/test/game';

  constructor(private http: HttpClient) { }

  getGames () {
    return this.http.get(this._url);
  }
}
