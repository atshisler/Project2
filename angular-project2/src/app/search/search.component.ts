import { Component, OnInit } from '@angular/core';
import { SearchService } from './search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public games = [];

  constructor(private _searchService: SearchService) { }

  ngOnInit() {

    this._searchService.getGames().subscribe(data =>
      {
        console.log(data);
        this.games = data;
      })
  }

}
