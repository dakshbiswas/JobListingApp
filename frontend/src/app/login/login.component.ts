import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService, TOKEN_NAME } from '../authentication.service';
import { User } from '../User.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  constructor(private authService: AuthenticationService, private router: Router) { }
  ngOnInit(): void {
  }

  loginUser() {
    console.log("Login user", this.user);
    console.log(localStorage.getItem(TOKEN_NAME));

    this.authService.loginUser(this.user).subscribe(data => {
      console.log("Login successful");
      if (data['token']) {
        this.authService.setToken(data['token']);
        this.authService.setFname(data['Fname']);
        this.authService.setLname(data['Lname']);
        this.authService.setUserId(data['userId']);
        console.log(localStorage.getItem(TOKEN_NAME));
        window.location.href = "/search";
      }

    },
      error => {
        alert("wrong credential");
      }
    );
  }
}
