import { Component, OnInit } from '@angular/core';
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Post} from "../../model/post";
import {PostserviceService} from "../../services/postservice.service";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer,private postService:PostserviceService) {
  }

  ngOnInit(): void {
  }

  selectedFile:any;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: any;
  imageName: any;
  tag!: string;
  lokacija!: string;
  slike:Array<number>=[]



  //Gets called when the user selects an image


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
      //this.router.navigate(['/newsfeed']);
      //sessionStorage.setItem('token', result.accessToken);

      /*for (let content of this.contents) {
        for(let image of content.slike) {
          this.images.push(image)
        }
      }*/
      console.log('success', result);
      this.slike.push(result.body);
      console.log(this.slike);

    }, err => {
      console.log('err', err);
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
    })
  }
}
