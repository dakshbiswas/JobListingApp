import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  @Input() job: any;
  public loggedIn = false;
  public checked: boolean;
  userId = localStorage.getItem('userId');

  constructor(
    private readonly route: ActivatedRoute,
    private http: HttpClient,
    private authService: AuthenticationService
  ) {
    this.checked = false;
    console.log("input success: ", this.route.queryParams['_value']['jobId']);
  }

  ngOnInit(): void {
    this.loggedIn = this.authService.isLoggedIn();
      this.http.get(`https://www.themuse.com/api/public/jobs/${this.route.queryParams['_value']['jobId']}`)
      .subscribe((data) => {this.job = data; console.log("in getJobDetails: ", data)});
      
      this.http.post("http://localhost:8081/favorites/api/v1/pair/exists",
      {
        "jobid": this.route.queryParams['value']['jobId'],
        "userid": this.userId
      })
      .subscribe((data: boolean) => this.checked=data);
  }

  saveFavorite(): boolean {
    this.http.post("http://localhost:8081/favorites/api/v1/jobs/save",
      {
        "jobid": this.job['id'],
        "userid": this.userId
      })
      .subscribe((data) => console.log("saved:", data))
      window.location.reload();
    return true;
  }

  deleteFavorite(): boolean {
    this.http.post("http://localhost:8081/favorites/api/v1/jobs/delete",
      {
        "jobid": this.job['id'],
        "userid": this.userId
      })
      .subscribe((data) => console.log("deleted: ", data))
      window.location.reload();
    return true;
  }

  addToFavourite() {
    this.http.post(`localhost:8080/favorites/api/v1/jobs/save`, JSON.stringify({
      userid: this.userId,
      jobid: ""
    })).subscribe(data => {
      this.job = data;
    });
    console.log("job", this.job);
    console.log("added", JSON.stringify({
      userid: this.userId,
      jobid: ""
    }));
  }
}
