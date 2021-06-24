import {Component, OnInit, Output, EventEmitter, HostListener} from '@angular/core';
import {UserLogin} from "../../model/user-login";
import { AuthService } from "../../services/auth.service";


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  @Output() onLogin : EventEmitter<UserLogin> = new EventEmitter();

  username!: string;
  password!: string;

  constructor(private authService : AuthService) { }

  ngOnInit(): void {
  }

  ngOnDestroy() {
    console.log('e')
  }

  onSubmit() {

    const user : UserLogin = {
      username: this.username,
      password: this.password,
    };

    this.onLogin.emit(user);

    console.log(user.username, user.password);

    this.username = '';
    this.password = '';

    console.log("JESSS")
  }


}
