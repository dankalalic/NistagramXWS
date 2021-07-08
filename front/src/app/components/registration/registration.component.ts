import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {UserLogin} from "../../model/user-login";
import {UserSignup} from "../../model/user-signup";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  username!: string;
  password!: string;
  ime! : string;
  prezime!: string;
  email! : string;
  telefon! : string;
  pol! : string;
  datum! : Date;
  biografija! : string;
  websajt! : string;

  constructor(private authService : AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const user : UserSignup = {
      ime : this.ime,
      prezime: this.prezime,
      username: this.username,
      lozinka: this.password,
      eMail : this.email,
      telefon: this.telefon,
      pol: this.pol,
      datumRodj: this.datum,
      biografija: this.biografija,
      websajt: this.websajt
    };

    this.authService.signup(user).subscribe(result =>
    {
      console.log('success');
      this.router.navigate(['/']);
    }, err => {
      this.router.navigate(['/error']);
    })
  }


}
