import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IGames } from './search';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private _url: string ="/assets/search.json";

  constructor(private http: HttpClient) { }

  getGames () : Observable<IGames[]>{
    return this.http.get<IGames[]>(this._url);
  }
}
