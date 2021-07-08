import {Component, Input, OnInit} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";
import {RegistracijaAgentaService} from "../../services/registracija-agenta.service";
import {ProizvodService} from "../../services/proizvod.service";

@Component({
  selector: 'app-prikazproizvoda',
  templateUrl: './prikazproizvoda.component.html',
  styleUrls: ['./prikazproizvoda.component.css']
})
export class PrikazproizvodaComponent implements OnInit {

  @Input() zahtevi! : [];

  constructor(private sanitizer:DomSanitizer, private router: Router, private zahtev:ProizvodService) { }

  ngOnInit(): void {
    this.zahtev.getProizvodi().subscribe(result =>
    {
      //this.router.navigate(['/newsfeed']);
      //sessionStorage.setItem('token', result.accessToken);
      console.log('success', result);
      this.zahtevi = result;
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

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

}
