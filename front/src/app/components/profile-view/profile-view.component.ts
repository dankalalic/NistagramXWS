import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile-view',
  templateUrl: './profile-view.component.html',
  styleUrls: ['./profile-view.component.css']
})
export class ProfileViewComponent implements OnInit {

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

  constructor(private authService : AuthService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }
    this.authService.profile().subscribe(result =>
    {
      console.log('success');
    }, err => {
      this.router.navigate(['/error']);
    })
  }

}
