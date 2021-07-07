import { Component, OnInit } from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {CampaignService} from "../../services/campaign.service";
import {NavigationExtras, Router} from "@angular/router";
import {JednokratnaKampanja} from "../../model/jednokratna-kampanja";
import {Visekratna} from "../../model/visekratna";

@Component({
  selector: 'app-kampanje-pregled',
  templateUrl: './kampanje-pregled.component.html',
  styleUrls: ['./kampanje-pregled.component.css']
})
export class KampanjePregledComponent implements OnInit {

  jednokratna : any;
  kampanje : any = [];
  constructor(private sanitizer:DomSanitizer, private campaignService : CampaignService, private router: Router) { }

  ngOnInit(): void {
  }

  chooseTipKampanje(event:any) {
    if(event.target.value == "Jednokratna") {
      this.jednokratna=true;
      this.getJednokratne();
    } else if (event.target.value == "Visekratna") {
      this.jednokratna=false;
      this.getVisekratne();
    }
    console.log(this.jednokratna);
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  getJednokratne() {
    this.campaignService.getJednokratne().subscribe(result => {
      this.kampanje=result;
      console.log('success', result);
    })
  }

  getVisekratne() {
    this.campaignService.getVisekratne().subscribe(result => {
      this.kampanje=result;
      console.log('success', result);
    })
  }



  /*jednokratnaIzmeni(kampanja : JednokratnaKampanja) {
    const navigationExtras: NavigationExtras = {
      jednokratnaKampanja : JednokratnaKampanja {
        kampanja: kampanja,
        jednokratna: this.jednokratna
      }
    };
    this.router.navigate(['/changeCampaign'])

  }*/
}
