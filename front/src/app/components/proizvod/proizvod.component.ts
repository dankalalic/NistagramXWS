import { Component, OnInit } from '@angular/core';
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {PostserviceService} from "../../services/postservice.service";
import {ZahtevkreiranjeService} from "../../services/zahtevkreiranje.service";
import {Zahtev} from "../../model/zahtev";
import {Proizvod} from "../../model/proizvod";
import {ProizvodService} from "../../services/proizvod.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-proizvod',
  templateUrl: './proizvod.component.html',
  styleUrls: ['./proizvod.component.css']
})
export class ProizvodComponent implements OnInit {

  constructor(private proizvodService : ProizvodService, private router: Router, private sanitizer:DomSanitizer,private postService:PostserviceService,private zahtevkreiranjeservice:ZahtevkreiranjeService) {
  }

  //OVO MOZDA TREBA IZMENITI DA PISE && sessionStorage.getItem("role") != "user"
  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "agent") {
      this.router.navigate(['error']);
    }
  }

  selectedFile:any;
  cena! : number;
  raspolozivoStanje! : number;
  slika!:number;
  prezime!:string;
  naziv!: string
  kategorija!:string;

  public onFileChanged(event:any) {
    this.selectedFile = event.target.files[0];
  }

  onUpload() {
    console.log(this.selectedFile);
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);

    this.proizvodService.upload(uploadImageData).subscribe(result =>
    {
      console.log('success', result);
      this.slika=result.body;
      console.log(this.slika);

    }, err => {
      this.router.navigate(['/error']);
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
    }, err => {
      this.router.navigate(['/error']);
    })

  }


}
