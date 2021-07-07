import { Component, OnInit } from '@angular/core';
import {regAgentDTO} from "../../model/regAgentDTO";
import {StringDTO} from "../../model/stringDTO";
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {RegistracijaAgentaService} from "../../services/registracija-agenta.service";

@Component({
  selector: 'app-admin-add-agent',
  templateUrl: './admin-add-agent.component.html',
  styleUrls: ['./admin-add-agent.component.css']
})
export class AdminAddAgentComponent implements OnInit {

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer, private registracijaAgenta:RegistracijaAgentaService) { }

  ngOnInit(): void {
  }

  username!:string;

  registrujAgenta() {
    const string :StringDTO={
      string:this.username,
    }

    this.registracijaAgenta.registrujAgenta(string).subscribe(result =>{
      console.log(result);
      alert(result.string);
    })

  }

}
