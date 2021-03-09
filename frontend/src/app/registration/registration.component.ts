import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { User } from '../User.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  newUser: User = new User();
  constructor(private authService: AuthenticationService,
              private router: Router,
              private http: HttpClient) { }

  ngOnInit(): void {
  }

  file: File = null;

  registerUser() {
    console.log("Register User data:", this.newUser);
    this.authService.registerUser(this.newUser).subscribe(data => {
      console.log("User registered", data);
      this.router.navigate(['/login']);
    },
    
    error =>{
      alert("User Already exist");
    });
  }

  onFileSelected(event){
    this.file = <File> event.target.files[0];
  }

  onUpload(){
    const fu = new FormData();
    fu.append('file', this.file,this.file.name);
    this.newUser.imageUrl = this.newUser.userId + this.file.type.replace('image/', '.'); 
    fu.append('userName', this.newUser.userId);
    this.http.post("http://localhost:8080/uploadimage", fu)
    .subscribe(res => {
      console.log("onupload repsone is -> " + res)
    });
  }
}
