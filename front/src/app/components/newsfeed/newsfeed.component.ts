import { Component, OnInit } from '@angular/core';
import {Id} from "../../model/id";
import {ContentService} from "../../services/content.service";
import {DomSanitizer} from "@angular/platform-browser";
import {StringDTO} from "../../model/stringDTO";
import {Router} from "@angular/router";

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css']
})
export class NewsfeedComponent implements OnInit {

  isAgent : any;
  public contents : any = [];

  constructor(private contentService : ContentService, private sanitizer:DomSanitizer, private router: Router) {
  }

  ngOnInit(): void {

    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
      console.log("ne radi")
    }

    this.isAgent = sessionStorage.getItem('role') != 'user';

    this.contentService.getNewsfeed().subscribe(result =>
    {
      this.contents = result;
      console.log('success', result);

    }, err => {
      this.router.navigate(['/error']);
    })

    this.contentService.getKampanje().subscribe(result =>
    {
      this.contents.push(result);
      console.log('success', result);

    }, err => {
      this.router.navigate(['/error']);
    })
  }

}
