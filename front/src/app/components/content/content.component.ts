import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ContentService} from "../../services/content.service";
import {UserLogin} from "../../model/user-login";
import {Id} from "../../model/id";
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  @Input() contents! : [];

  //public contents : any = [];
  //public images : any = [];

  constructor(private contentService : ContentService, private sanitizer:DomSanitizer) {
  }

  ngOnInit(): void {

  }


  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }


}
