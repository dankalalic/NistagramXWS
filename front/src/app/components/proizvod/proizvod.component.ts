import { Component, OnInit } from '@angular/core';
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {PostserviceService} from "../../services/postservice.service";
import {ZahtevkreiranjeService} from "../../services/zahtevkreiranje.service";
import {Zahtev} from "../../model/zahtev";
import {Proizvod} from "../../model/proizvod";
import {ProizvodService} from "../../services/proizvod.service";

@Component({
  selector: 'app-proizvod',
  templateUrl: './proizvod.component.html',
  styleUrls: ['./proizvod.component.css']
})
export class ProizvodComponent implements OnInit {

  constructor(private proizvodService : ProizvodService, private sanitizer:DomSanitizer,private postService:PostserviceService,private zahtevkreiranjeservice:ZahtevkreiranjeService) {
  }

  ngOnInit(): void {
  }

  selectedFile:any;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: any;
  imageName: any;
  cena! : number;
  raspolozivoStanje! : number;
  slika!:number;
  prezime!:string;
  naziv!: string
  kategorija!:string;




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

    this.proizvodService.upload(uploadImageData).subscribe(result =>
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

  createProizvod() {
    const proizvod :Proizvod={
      cena:this.cena,
      raspolozivoStanje:this.raspolozivoStanje,
      slika:this.slika,
      naziv:this.naziv

    }
    this.proizvodService.createProizvod(proizvod).subscribe(result =>{
      console.log(result);
    })

  }


}
