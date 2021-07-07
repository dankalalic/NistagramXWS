import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {CampaignService} from "../../services/campaign.service";
import {UserLogin} from "../../model/user-login";
import {JednokratnaKampanja} from "../../model/jednokratna-kampanja";
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Id} from "../../model/id";
import {Slika} from "../../model/slika";
import {FormArray, FormControl} from "@angular/forms";
import {Visekratna} from "../../model/visekratna";
import DateTimeFormat = Intl.DateTimeFormat;

@Component({
  selector: 'app-create-campaign',
  templateUrl: './create-campaign.component.html',
  styleUrls: ['./create-campaign.component.css']
})
export class CreateCampaignComponent implements OnInit {

  pol!: string;
  godPocetka!: number;
  godKraja!: number;
  datum!: DateTimeFormat;
  datumk!: DateTimeFormat;
  slike: Array<Slika>=[];
  proizvodi! : [];
  jednokratna : any;
  datumpocetka!: Date;
  datumkraja!: Date;
  brojplasiranja!: number;

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer, private campaignService : CampaignService, private router: Router) { }

  ngOnInit(): void {
    this.getByAgent();
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  onSubmit() {

    if(this.jednokratna==true) {
      const kampanja: JednokratnaKampanja = {
        pol: this.pol,
        godinePocetka: this.godPocetka,
        godineKraja: this.godKraja,
        slike: this.slike,
        //linkovi: ['g', 'g'],
        pocetakPrikazivanja: this.datum,
        krajPrikazivanja: this.datumk
      };

      console.log(kampanja)
      this.btnCreateJednokratna(kampanja)

    } else if(this.jednokratna==false) {
      const kampanja: Visekratna = {
        pol: this.pol,
        godinePocetka: this.godPocetka,
        godineKraja: this.godKraja,
        slike: this.slike,
        //linkovi: ['g', 'g'],
        pocetakPrikazivanja: this.datumpocetka,
        krajPrikazivanja: this.datumkraja,
        potrebanBrojPrikazivanja: this.brojplasiranja
      };

      this.btnCreateVisekratna(kampanja)
    }
  }

  chooseTipKampanje(event:any) {
    if(event.target.value == "Jednokratna") {
      this.jednokratna=true;
    } else if (event.target.value == "Visekratna") {
      this.jednokratna=false;
    }
    console.log(this.jednokratna);
  }

  onChange(proizvod:any, event:any) {
    let slika : Slika = new Slika(proizvod['slika']['name'], proizvod['slika']['url'], proizvod['slika']['size']);

    //console.log(slika)
    if(event.target.checked) {
      this.slike.push(slika);
      console.log('pushed', this.slike)
    } else {
      let index = this.slike.findIndex(x => x.url == proizvod.slika.url)
      this.slike.splice(index, 1);
      console.log('popped', this.slike)
    }
  }

  btnCreateJednokratna(kampanja : JednokratnaKampanja) {
    this.campaignService.create(kampanja).subscribe(result => {
      console.log('success');
    })
  }

  btnCreateVisekratna(kampanja : Visekratna) {
    this.campaignService.createVisekatna(kampanja).subscribe(result => {
      console.log('success');
    })
  }

  getByAgent() {
    this.campaignService.getByAgent().subscribe(result => {
      this.proizvodi=result;
      //for (var i = 0; i < result.length; i++) {
        //let slika : Slika = new Slika(result[i].slika.name, result[i].slika.url, result[i].slika.size);
        //this.slike.push(slika);
        //console.log(slika);

      //}
      console.log('g',result)
    }, err => {
      this.router.navigate(['/error']);
    })
  }
}
