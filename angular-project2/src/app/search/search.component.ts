import { Component, OnInit } from '@angular/core';
import { SearchService } from './search.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private _url: string ='http://localhost:8080/name-and-game/game/search/zelda';
  games;

  constructor(private _searchService: SearchService, private http: HttpClient) { }

  ngOnInit() {
    this.http.get(this._url).subscribe(data =>
      {
        JSON.stringify(this.games);
       this.games = data;
        console.log(data);
     })
  }

}
