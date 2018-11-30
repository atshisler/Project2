import { Component, OnInit } from '@angular/core';
import { SearchService } from './search.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private _url: string ='http://localhost:8080/name-and-game/test/game';
  games;

  constructor(private _searchService: SearchService, private http: HttpClient) { }

  // getPlatform(): void{
  //   this.http.getGames()
  //   .subscribe(
  //     games =>
  //       {
  //         this.games = games;
  //         console.log('this.games=' + this.games);
  //         console.log('this.games.length= ' + this.games.length);
  //         console.log('this.games[0].name= ' + this.games[0].name);
  //       }
  //   )
  // }

  ngOnInit() {
    this.http.get(this._url).subscribe(data =>
      {
       this.games = data;
        console.log(this.games);
        console.log('this.games.title = ' + this.games[0].title);
     })
  }

}
