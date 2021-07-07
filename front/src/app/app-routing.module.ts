import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginFormComponent} from "./components/login-form/login-form.component";
import {AppComponent} from "./app.component";
import {ContentComponent} from "./components/content/content.component";
import {AuthService} from "./services/auth.service";
import {NewsfeedComponent} from "./components/newsfeed/newsfeed.component";
import {ProfileViewComponent} from "./components/profile-view/profile-view.component";
import {VerificationUploadComponent} from "./components/verification-upload/verification-upload.component";
import {PostComponent} from "./components/post/post.component";
import {ZahtevComponent} from "./components/zahtev/zahtev.component";
import {LajkovanoComponent} from "./components/lajkovano/lajkovano.component";
import {DislajkovanoComponent} from "./components/dislajkovano/dislajkovano.component";
import {SearchChoiceComponent} from "./components/search-choice/search-choice.component";
import {ErrorComponent} from "./components/error/error.component";
import {CreateCampaignComponent} from "./components/create-campaign/create-campaign.component";

import {KampanjePregledComponent} from "./components/kampanje-pregled/kampanje-pregled.component";
import {CampaignChangeComponent} from "./components/campaign-change/campaign-change.component";
import {ProizvodComponent} from "./components/proizvod/proizvod.component";



const routes: Routes = [
  { path: '', component: LoginFormComponent},
  { path: 'newsfeed', component: NewsfeedComponent},
  { path: 'profile', component: ProfileViewComponent},
  {path: 'verification', component: VerificationUploadComponent},
  {path: 'createpost', component: PostComponent},
  {path: 'zahtev', component: ZahtevComponent},
  {path: 'lajkovano', component: LajkovanoComponent},
  {path: 'dislajkovano', component: DislajkovanoComponent},
  { path: 'search', component: SearchChoiceComponent},
  { path: 'error', component : ErrorComponent},
  { path: 'post', component: PostComponent },
  { path: 'createCampaign', component: CreateCampaignComponent},
  { path: 'kampanjePregled', component: KampanjePregledComponent},
  { path: 'changeCampaign', component: CampaignChangeComponent},
  { path: 'createProizvod', component: ProizvodComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
