import { Component, OnInit } from '@angular/core';
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Post} from "../../model/post";
import {PostserviceService} from "../../services/postservice.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private verificationService : VerificationUploadService, private router: Router, private sanitizer:DomSanitizer,private postService:PostserviceService) {
  }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }
  }

  selectedFile:any;
  tag!: string;
  lokacija!: string;
  slike:Array<number>=[]

  public onFileChanged(event:any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }

  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);

    this.verificationService.upload(uploadImageData).subscribe(result =>
    {
      console.log('success', result);
      this.slike.push(result.body);
      console.log(this.slike);

    }, err => {
      this.router.navigate(['/error']);
    })
  }

  createPost() {
    const post :Post={
      userId:2,
      tag:this.tag,
      lokacija:this.lokacija,
      slike:this.slike
    }
    this.postService.createPost(post).subscribe(result =>{
      console.log(result);
    }, err => {
      this.router.navigate(['/error']);
    })
  }
}
