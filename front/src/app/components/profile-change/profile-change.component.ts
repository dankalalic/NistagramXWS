import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {UserSignup} from "../../model/user-signup";
import {UserChange} from "../../model/user-change";

@Component({
  selector: 'app-profile-change',
  templateUrl: './profile-change.component.html',
  styleUrls: ['./profile-change.component.css']
})
export class ProfileChangeComponent implements OnInit {

  username!: string;
  password!: string;
  ime!: string;
  prezime!: string;
  email!: string;
  telefon!: string;
  pol!: string;
  datum!: Date;
  biografija!: string;
  websajt!: string;
  allowNotifs!: boolean;
  acceptMsg!: boolean;
  taggable!: boolean;
  isp!: boolean;

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }
  }

  onSubmit() {
    const user: UserSignup = {
      ime: this.ime,
      prezime: this.prezime,
      username: this.username,
      lozinka: this.password,
      eMail: this.email,
      telefon: this.telefon,
      pol: this.pol,
      datumRodj: this.datum,
      biografija: this.biografija,
      websajt: this.websajt
    };

    const userPrivacy: UserChange = {
      allowNotifs: this.allowNotifs,
      acceptmsg: this.acceptMsg,
      taggable: this.taggable,
      isp: this.isp
    };

    this.authService.changeProfil(user).subscribe(result => {
      console.log('success');
      //this.router.navigate(['/']);
    }, err => {
      this.router.navigate(['/error']);
    })

    this.authService.changePrivacy(userPrivacy).subscribe(result => {
      console.log('success');
      this.router.navigate(['/']);
    }, err => {
      this.router.navigate(['/error']);
    })
  }
}
