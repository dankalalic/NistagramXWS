import { Component, OnInit } from '@angular/core';
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {PostserviceService} from "../../services/postservice.service";
import {Post} from "../../model/post";
import {Zahtev} from "../../model/zahtev";
import{ZahtevService} from "../../services/zahtev.service";
import {ZahtevkreiranjeService} from "../../services/zahtevkreiranje.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-zahtev',
  templateUrl: './zahtev.component.html',
  styleUrls: ['./zahtev.component.css']
})
export class ZahtevComponent implements OnInit {

  constructor(private verificationService : VerificationUploadService, private router: Router, private sanitizer:DomSanitizer,private postService:PostserviceService,private zahtevkreiranjeservice:ZahtevkreiranjeService) {
  }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }
  }

  selectedFile:any;
  tag!: string;
  lokacija!: string;
  ime!:string;
  prezime!:string;
  kategorija!:string;
  slika!:number;

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
      this.slika=result.body;
      console.log(this.slika);

    }, err => {
      this.router.navigate(['/error']);
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
    }, err => {
      this.router.navigate(['/error']);
    })

  }

}
