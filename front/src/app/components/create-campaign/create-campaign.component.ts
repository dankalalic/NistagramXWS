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

@Component({
  selector: 'app-create-campaign',
  templateUrl: './create-campaign.component.html',
  styleUrls: ['./create-campaign.component.css']
})
export class CreateCampaignComponent implements OnInit {

  pol!: string;
  godPocetka!: number;
  godKraja!: number;
  datum!: Date;
  slike: Array<Slika>=[];
  proizvodi! : [];

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer, private campaignService : CampaignService, private router: Router) { }

  ngOnInit(): void {
    this.getByAgent();
  }

  public onFileChanged(event:any) {
    //Select File
    this.slike = event.target.files[0];
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  onSubmit() {

    //this.onUpload();

    const kampanja : JednokratnaKampanja = {
      pol: this.pol,
      godinePocetka: this.godPocetka,
      godineKraja: this.godKraja,
      slike : this.slike,
      linkovi: ['g'],
      datumPrikazivanja: this.datum,
    };


    this.btnCreate(kampanja)
  }

  /*onUpload() {
    for (let slika in this.slike) {
      const uploadImageData = new FormData();
      uploadImageData.append('imageFile', slika, slika.name);

      this.campaignService.upload(uploadImageData).subscribe(result => {
        console.log('success', result);
        this.slika = result.body;
        console.log(this.slika);
      }, err => {
        console.log('err', err);
      })
    }
  }*/

  btnCreate(kampanja : JednokratnaKampanja) {
    this.campaignService.create(kampanja).subscribe(result => {
      console.log('success');
    })
  }

  getByAgent() {
    this.campaignService.getByAgent().subscribe(result => {
      this.proizvodi=result;
      for (var i = 0; i < result.length; i++) {
        let slika : Slika = new Slika(result[i].slika.name, result[i].slika.url, result[i].slika.size);
        this.slike.push(slika);
        console.log(slika);

      }
      console.log('g',result)
    }, err => {
      this.router.navigate(['/error']);
    })
  }
}
