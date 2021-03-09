import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent {
  jobs$: any;
  
  constructor(private readonly route: ActivatedRoute,
    private http: HttpClient) {
    console.log("in results.component:", this.route.queryParams['_value']['myquery']);
    this.getSearchResults(this.route.queryParams['_value']['myquery']);
  }


  getSearchResults(query: string) {
    this.http.get(`https://www.themuse.com/api/public/jobs?page=1&category=${query}`)
      .subscribe((data) => { this.jobs$ = data['results']; console.log("in getSearchResults: ", data['results']) });
    console.log("fetched");
  }
}
