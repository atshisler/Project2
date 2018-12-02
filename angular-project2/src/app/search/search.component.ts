import { Component, OnInit } from '@angular/core';
import { SearchService } from './search.service';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators'

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private _url: string ='http://ec2-3-16-11-92.us-east-2.compute.amazonaws.com:8080/name-and-game/game/search/';
  games;

  searchCo : string;
  
  
    // search: string = '';
    // private _urlSearch: string = `http://localhost:8080/name-and-game/game/search/${this.search}`;
  

  /* 
    string ''
    string contains user input
    private url2: string='address'${string}
  */

  constructor(private _searchService: SearchService, private http: HttpClient) { }

  ngOnInit() {
  }
  
  getSearchService()
  {
    this._searchService.search = this.searchCo;
    console.log(this._searchService);
    this.retriveSearch();
    return this._searchService;
  }

  retriveSearch()
  {
    this.http.get(this._url + this.searchCo).subscribe(data =>
      {
        console.log("hit");
        JSON.stringify(this.games);
        this.games = data;
        console.log(data);
     })
  }

  // searchGame()
  // {
  //   return this.http.get<object[]>(this._urlSearch).pipe(map(data => data));
  // }

}
