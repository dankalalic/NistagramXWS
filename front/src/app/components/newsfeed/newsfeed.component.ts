import { Component, OnInit } from '@angular/core';
import {Id} from "../../model/id";
import {ContentService} from "../../services/content.service";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css']
})
export class NewsfeedComponent implements OnInit {

  public contents : any = [];
  //public images : any = [];

  constructor(private contentService : ContentService, private sanitizer:DomSanitizer) {
  }

  ngOnInit(): void {
    const id : Id = {
      id : 2
    };
    this.contentService.getNewsfeed(id).subscribe(result =>
    {
      //this.router.navigate(['/newsfeed']);
      //sessionStorage.setItem('token', result.accessToken);
      this.contents = result;
      /*for (let content of this.contents) {
        for(let image of content.slike) {
          this.images.push(image)
        }
      }*/
      console.log('success', result);

    }, err => {
      console.log('err', err);
    })
  }

}
