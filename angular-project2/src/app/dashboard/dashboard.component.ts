import { Component, OnInit } from '@angular/core';
import { SearchService } from '../search/search.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  private _url: string ='http://localhost:8080/name-and-game/game/search/zelda';
  games;

  constructor(private _searchService: SearchService, private http: HttpClient) { }

  ngOnInit() {
    this.http.get(this._url).subscribe(data =>
      {
        this.games = data;
        console.log(data);
        //console.log(data);
     });
  }

}
