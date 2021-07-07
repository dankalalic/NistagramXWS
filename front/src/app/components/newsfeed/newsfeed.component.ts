import { Component, OnInit } from '@angular/core';
import {Id} from "../../model/id";
import {ContentService} from "../../services/content.service";
import {DomSanitizer} from "@angular/platform-browser";
import {StringDTO} from "../../model/stringDTO";

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css']
})
export class NewsfeedComponent implements OnInit {

  isAgent : any;
  public contents : any = [];


  constructor(private contentService : ContentService, private sanitizer:DomSanitizer) {
  }


  ngOnInit(): void {

    this.isAgent = sessionStorage.getItem('role') != 'user';

    this.contentService.getNewsfeed().subscribe(result =>
    {
      this.contents = result;
      console.log('success', result);

    }, err => {
      console.log('err', err);
    })

    this.contentService.getKampanje().subscribe(result =>
    {
      this.contents.push(result);
      console.log('success', result);

    }, err => {
      console.log('err', err);
    })
  }

}
