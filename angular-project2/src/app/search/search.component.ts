import { Component, OnInit } from '@angular/core';
import { SearchService } from './search.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private _url: string ='http://ec2-3-16-11-92.us-east-2.compute.amazonaws.com:8080/name-and-game/test/game';
  games;

  constructor(private _searchService: SearchService, private http: HttpClient) { }

  ngOnInit() {
    this.http.get(this._url).subscribe(data =>
      {
        this.games = data;
        console.log(this.games);
      })
  }

}
