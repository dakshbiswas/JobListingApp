import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  FirstName: String;
  LastName: String;
  UserId : String;
  imageUrl: String;

  constructor(private http: HttpClient) {}
  file: File = null;

  ngOnInit(): void {
    this.FirstName = localStorage.getItem("Fname");  
    this.LastName = localStorage.getItem("Lname");  
    this.UserId = localStorage.getItem("userId");  
    this.imageUrl = "http://localhost:8080/downloadimage/"+this.UserId;
  }

}
