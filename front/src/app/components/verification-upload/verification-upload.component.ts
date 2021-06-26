import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Id} from "../../model/id";
import {ContentService} from "../../services/content.service";
import {DomSanitizer} from "@angular/platform-browser";
import {VerificationUploadService} from "../../services/verification-upload.service";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Component({
  selector: 'app-verification-upload',
  templateUrl: './verification-upload.component.html',
  styleUrls: ['./verification-upload.component.css']
})


export class VerificationUploadComponent implements OnInit {

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer) {
  }

  ngOnInit(): void {
  }

  selectedFile:any;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: any;
  imageName: any;



  //Gets called when the user selects an image
  public onFileChanged(event) {
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

    }, err => {
      console.log('err', err);
    })
  }

    //Make a call to the Spring Boot Application to save the image





}
