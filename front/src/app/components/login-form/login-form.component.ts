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

    this.btnLogin(user);

    this.username = '';
    this.password = '';
  }

  btnLogin(user : UserLogin) {
    this.authService.login(user).subscribe(result =>
    {
      sessionStorage.setItem('token', '');
      sessionStorage.setItem('role', '');
      sessionStorage.setItem('token', result.accessToken);
      sessionStorage.setItem('role', result.role);

      if ((result.role == 'user' || result.role == 'agent') && result.enabled == true) {
        this.router.navigate(['/newsfeed']);
      } else if (result.role == 'admin') {
        this.router.navigate(['/neprikladansadrzaj']);
      }
    }, err => {
      this.router.navigate(['/error']);
    })
  }

}
