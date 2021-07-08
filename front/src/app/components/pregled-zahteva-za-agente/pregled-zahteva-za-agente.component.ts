import {Component, Input, OnInit} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";
import {PostService} from "../../services/post.service";
import {ZahtevkreiranjeService} from "../../services/zahtevkreiranje.service";
import {Id} from "../../model/id";
import {RegistracijaAgentaService} from "../../services/registracija-agenta.service";

@Component({
  selector: 'app-pregled-zahteva-za-agente',
  templateUrl: './pregled-zahteva-za-agente.component.html',
  styleUrls: ['./pregled-zahteva-za-agente.component.css']
})
export class PregledZahtevaZaAgenteComponent implements OnInit {

  @Input() zahtevi! : [];

  constructor(private sanitizer:DomSanitizer, private router: Router, private zahtev:RegistracijaAgentaService) { }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "admin") {
      this.router.navigate(['error']);
    }
    this.zahtev.getZahtevi().subscribe(result =>
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
      this.router.navigate(['/error']);
    })
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  prihvati(id:number){
    const id1 : Id = {
      id : id
    }

    this.zahtev.prihvati(id1).subscribe(result => {
      console.log(result)
      alert(result.string);
    }, err => {
      this.router.navigate(['/error']);
    })

  }

  odbij(id:number){
    const id1 : Id = {
      id : id
    }

    this.zahtev.odbij(id1).subscribe(result => {
      console.log(result)
      alert(result.string);
    }, err => {
      this.router.navigate(['/error']);
    })

  }

}
