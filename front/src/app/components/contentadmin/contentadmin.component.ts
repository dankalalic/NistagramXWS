import {Component, Input, OnInit} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";
import {Id} from "../../model/id";
import {PostService} from "../../services/post.service";
import {AuthService} from "../../services/auth.service";
import {StringDTO} from "../../model/stringDTO";

@Component({
  selector: 'app-contentadmin',
  templateUrl: './contentadmin.component.html',
  styleUrls: ['./contentadmin.component.css']
})
export class ContentadminComponent implements OnInit {
  @Input() admincontents! : [];
  constructor(private sanitizer:DomSanitizer, private router: Router, private postService:PostService, private authService:AuthService) { }

  ngOnInit(): void {
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  ukloniSadrzaj(id:number){
    console.log(id);
    const id1 : Id = {
      id : id
    }

    this.postService.ukloni(id1).subscribe(result => {
      console.log(result)
      alert(result.string);
    }, err => {
      this.router.navigate(['/error']);
    })

  }

  ugasiProfil(string:string){
    console.log(string);
    const username1 : StringDTO = {
      string : string
    }
    console.log(username1);
    this.authService.ugasiProfil(username1).subscribe(result => {
      console.log(result);
      alert(result.string);

    }, err => {
      this.router.navigate(['/error']);
    })
  }

}
