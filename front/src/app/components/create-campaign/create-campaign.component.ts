import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {CampaignService} from "../../services/campaign.service";
import {UserLogin} from "../../model/user-login";
import {JednokratnaKampanja} from "../../model/jednokratna-kampanja";
import {VerificationUploadService} from "../../services/verification-upload.service";
import {DomSanitizer} from "@angular/platform-browser";

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
  slika!:any;

  constructor(private verificationService : VerificationUploadService, private sanitizer:DomSanitizer, private campaignService : CampaignService, private router: Router) { }

  ngOnInit(): void {
  }

  public onFileChanged(event:any) {
    //Select File
    this.slika = event.target.files[0];
  }

  onSubmit() {

    this.onUpload();

    const kampanja : JednokratnaKampanja = {
      pol: this.pol,
      godinePocetka: this.godPocetka,
      godineKraja: this.godKraja,
      slike : this.slika,
      linkovi: [],
      datumPrikazivanja: this.datum,
    };

    this.btnLogin(kampanja)
  }

  onUpload() {
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.slika, this.slika.name);

    this.campaignService.upload(uploadImageData).subscribe(result =>
    {
      console.log('success', result);
      this.slika=result.body;
      console.log(this.slika);
    }, err => {
      console.log('err', err);
    })
  }

  btnLogin(kampanja : JednokratnaKampanja) {
    this.campaignService.create(kampanja).subscribe(result => {
      console.log('success');
    })
  }
}
