import { Component, OnInit } from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {CampaignService} from "../../services/campaign.service";
import {ActivatedRoute, NavigationExtras, Router} from "@angular/router";
import {JednokratnaKampanja} from "../../model/jednokratna-kampanja";
import {Visekratna} from "../../model/visekratna";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";
import {Id} from "../../model/id";

@Component({
  selector: 'app-kampanje-pregled',
  templateUrl: './kampanje-pregled.component.html',
  styleUrls: ['./kampanje-pregled.component.css']
})
export class KampanjePregledComponent implements OnInit {

  jednokratna : any;
  kampanje : any = [];

  constructor(public activatedRoute: ActivatedRoute, private sanitizer:DomSanitizer, private campaignService : CampaignService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "agent") {
      this.router.navigate(['error']);
    }
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
    }, err => {
      this.router.navigate(['/error']);
    })
  }

  getVisekratne() {
    this.campaignService.getVisekratne().subscribe(result => {
      this.kampanje=result;
      console.log('success', result);
    }, err => {
      this.router.navigate(['/error']);
    })
  }

  navigateWithState(kampanja : any) {
    this.router.navigateByUrl('/changeCampaign', { state: { kampanja: kampanja, jednokratna: this.jednokratna } });
  }

  delete(kampanja: any) {
    const id : Id = {
      id : kampanja.id
    }
    if (this.jednokratna) {
      this.campaignService.deleteJednokratna(id).subscribe(result => {
        console.log("success");
      }, err => {
        this.router.navigate(['/error']);
      })
    } else {
      this.campaignService.deleteVisekratna(id).subscribe(result => {
        console.log("success");
      }, err => {
        this.router.navigate(['/error']);
      })
    }
  }

}
