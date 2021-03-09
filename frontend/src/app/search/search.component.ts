import { HttpClient } from '@angular/common/http';
import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent{
  jobs$: any;
  @Output() job$;
  query: string;
  constructor(private http: HttpClient) {
  }

  getSearchResults(query: string){
    this.http.get(`https://www.themuse.com/api/public/jobs?page=1&category=${query}`)
    .subscribe((data) => {this.jobs$=data['results']; console.log("in getSearchResults: ", data['results'])});
    window.location.href = `results`
    console.log("fetched");
  }
}
