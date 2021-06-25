import {Component, OnInit, Output, EventEmitter, HostListener} from '@angular/core';
import {UserLogin} from "../../model/user-login";
import { AuthService } from "../../services/auth.service";
import {Router} from "@angular/router"


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  //@Output() onLogin : EventEmitter<UserLogin> = new EventEmitter();

  username!: string;
  password!: string;

  constructor(private authService : AuthService, private router: Router) { }

  ngOnInit(): void {
  }


  onSubmit() {

    const user : UserLogin = {
      username: this.username,
      password: this.password,
    };

    //this.onLogin.emit(user);
    this.btnLogin(user);

    console.log(user.username, user.password);

    this.username = '';
    this.password = '';

    console.log("JESSS")

  }

  btnLogin(user : UserLogin) {
    console.log('hh');
    //this.router.navigate(['newsfeed']);
    this.authService.login(user).subscribe(result =>
    {
      this.router.navigate(['/newsfeed']);
      sessionStorage.setItem('token', result.accessToken);
      sessionStorage.setItem('role', result.role);

    }, err => {
      console.log('err')})
  }

}
