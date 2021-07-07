import { Component, OnInit } from '@angular/core';
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {RegistracijaAgentaService} from "../../services/registracija-agenta.service";
import {Zahtev} from "../../model/zahtev";
import {regAgentDTO} from "../../model/regAgentDTO";

@Component({
  selector: 'app-registracija-agenta',
  templateUrl: './registracija-agenta.component.html',
  styleUrls: ['./registracija-agenta.component.css']
})
export class RegistracijaAgentaComponent implements OnInit {

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer, private registracijaAgenta:RegistracijaAgentaService) { }

  ngOnInit(): void {
  }

  email!:string;
  websajt!:string;

  createRegistracija() {
    const registracija :regAgentDTO={
      email:this.email,
      websajt:this.websajt
    }

    this.registracijaAgenta.createRegistracija(registracija).subscribe(result =>{
      console.log(result);
    })

  }

}
