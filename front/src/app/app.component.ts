import { Component } from '@angular/core';
import {UserLogin} from "./model/user-login";
import { AuthService} from "./services/auth.service";
import {Router} from "@angular/router"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private authService : AuthService, private router: Router) { }

  title = 'Log in';

  btnLogin(user : UserLogin) {
    console.log('hh');
    this.router.navigate(['newsfeed']);
    this.authService.login(user).subscribe(result =>
    {
        //this.router.navigate(['/newsfeed']);
        sessionStorage.setItem('token', result.accessToken);

    }, err => {
        console.log('err')})
  }
}
