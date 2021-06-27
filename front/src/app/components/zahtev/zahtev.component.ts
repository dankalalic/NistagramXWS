import { Component, OnInit } from '@angular/core';
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {PostserviceService} from "../../services/postservice.service";
import {Post} from "../../model/post";
import {Zahtev} from "../../model/zahtev";
import{ZahtevService} from "../../services/zahtev.service";
import {ZahtevkreiranjeService} from "../../services/zahtevkreiranje.service";

@Component({
  selector: 'app-zahtev',
  templateUrl: './zahtev.component.html',
  styleUrls: ['./zahtev.component.css']
})
export class ZahtevComponent implements OnInit {

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer,private postService:PostserviceService,private zahtevkreiranjeservice:ZahtevkreiranjeService) {
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
  ime!:string;
  prezime!:string;
  kategorija!:string;
  slika!:number;



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
      this.slika=result.body;
      console.log(this.slika);

    }, err => {
      console.log('err', err);
    })
  }

  createZahtev() {
    const zahtev :Zahtev={
      ime:this.ime,
      prezime:this.prezime,
      kategorija:this.kategorija,
      slika:this.slika
    }
    this.zahtevkreiranjeservice.createZahtev(zahtev).subscribe(result =>{
      console.log(result);
    })

  }

}
