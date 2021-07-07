import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {map} from "rxjs/operators";
import {DomSanitizer} from "@angular/platform-browser";
import {CampaignService} from "../../services/campaign.service";
import {JednokratnaKampanja} from "../../model/jednokratna-kampanja";
import {Visekratna} from "../../model/visekratna";
import DateTimeFormat = Intl.DateTimeFormat;
@Component({
  selector: 'app-campaign-change',
  templateUrl: './campaign-change.component.html',
  styleUrls: ['./campaign-change.component.css']
})
export class CampaignChangeComponent implements OnInit {

  kampanja : any;
  jednokratna : Boolean;
  pol! : string;
  godinePocetka! : number;
  godineKraja!: number;
  pocetakPrikazivanja!: DateTimeFormat;
  krajPrikazivanja!: DateTimeFormat;
  pocetakPrikazivanja1! : Date;
  krajPrikazivanja1! : Date;
  potrebanBrojPrikaza! : number;
  id : number;


  constructor(public activatedRoute: ActivatedRoute, private sanitizer:DomSanitizer, private campaignService : CampaignService, private router: Router) {
    // @ts-ignore
    this.kampanja = this.router.getCurrentNavigation().extras.state.kampanja;
    // @ts-ignore
    this.jednokratna = this.router.getCurrentNavigation().extras.state.jednokratna;
    this.pol = this.kampanja['ciljnaGrupa']['pol']
    this.godinePocetka = this.kampanja['ciljnaGrupa']['godinePocetka']
    this.godineKraja = this.kampanja['ciljnaGrupa']['godineKraja']
    this.pocetakPrikazivanja = this.kampanja['pocetakPrikazivanja']
    this.krajPrikazivanja = this.kampanja['krajPrikazivanja']
    this.id = this.kampanja['id']
    this.pocetakPrikazivanja1 = this.kampanja['pocetakPrikazivanja1']
    this.krajPrikazivanja1 = this.kampanja['krajPrikazivanja1']
    this.potrebanBrojPrikaza = this.kampanja['potrebanBrojPrikazivanja']
  }

  ngOnInit(): void {
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  onSubmit() {

    if(this.jednokratna) {
      const kampanja: JednokratnaKampanja = {
        id: this.id,
        pol: this.pol,
        godinePocetka: this.godinePocetka,
        godineKraja: this.godineKraja,
        slike: [],
        //linkovi: ['g', 'g'],
        pocetakPrikazivanja: this.pocetakPrikazivanja,
        krajPrikazivanja: this.krajPrikazivanja
      };

      console.log(kampanja)
      this.btnChangeJednokratna(kampanja)

    } else if(!this.jednokratna) {
      const kampanja: Visekratna = {
        id : this.id,
        pol: this.pol,
        godinePocetka: this.godinePocetka,
        godineKraja: this.godineKraja,
        slike: [],
        //linkovi: ['g', 'g'],
        pocetakPrikazivanja: this.pocetakPrikazivanja1,
        krajPrikazivanja: this.krajPrikazivanja1,
        potrebanBrojPrikazivanja: this.potrebanBrojPrikaza
      };
      console.log(kampanja);
      this.btnChangeVisekratna(kampanja)
    }
  }

  btnChangeJednokratna(kampanja : JednokratnaKampanja) {
    this.campaignService.changeJednokratna(kampanja).subscribe(result => {
      console.log('success');
    })
  }

  btnChangeVisekratna(kampanja : Visekratna) {
    this.campaignService.changeVisekratna(kampanja).subscribe(result => {
      console.log('success');
    })
  }

  onChangePol(event : any) {
    this.pol = event.target.value;
  }

  onChangeGodPocetka(event : any) {
    this.godinePocetka = event.target.value;
  }

  onChangeGodKraja(event : any) {
    this.godineKraja = event.target.value;
  }

  onChangePocetakPrikaz(event : any) {
    this.pocetakPrikazivanja = event.target.value;
  }

  onChangeKrajPrikaz(event : any) {
    this.krajPrikazivanja = event.target.value;
  }

  onChangePocetakPrikaz1(event : any) {
    this.pocetakPrikazivanja1 = event.target.value;
  }

  onChangeKrajPrikaz1(event : any) {
    this.krajPrikazivanja1 = event.target.value;
  }

  onChangePotrebanBrojPrikaza(event : any) {
    this.potrebanBrojPrikaza = event.target.value;
  }

}
