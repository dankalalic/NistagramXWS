import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ContentService} from "../../services/content.service";
import {UserLogin} from "../../model/user-login";
import {Id} from "../../model/id";
import {PostService} from "../../services/post.service";
import {DomSanitizer} from '@angular/platform-browser';
import {StringDTO} from "../../model/stringDTO";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  @Input() contents! : [];

  constructor(private contentService : ContentService, private postService:PostService, private sanitizer:DomSanitizer, private router: Router) {
  }

  ngOnInit(): void {
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  report(id:number) {

    console.log('okk');
    const id1 : Id = { id : id};
    //this.router.navigate(['newsfeed']);
    this.postService.report(id1).subscribe(result =>
      {
        console.log(result);
        alert(result.string);
      }
    );

  }


  like(id : number) {
    console.log(id);
    const id1 : Id = {
      id : id
    }
    this.contentService.like(id1).subscribe(result => {
      console.log(result)
  }, err => {
      this.router.navigate(['/error']);
  })
  }

  dislike(id : number) {
    const id1 : Id = {
      id : id
    }
    this.contentService.dislike(id1).subscribe(result => {
      console.log(result)
    }, err => {
      this.router.navigate(['/error']);
    })
  }


}
