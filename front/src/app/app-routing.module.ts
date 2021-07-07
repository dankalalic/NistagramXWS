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
import {NavbaradminComponent} from "./components/navbaradmin/navbaradmin.component";
import {NeprikladansadrzajComponent} from "./components/neprikladansadrzaj/neprikladansadrzaj.component";
import {RegistracijaAgentaComponent} from "./components/registracija-agenta/registracija-agenta.component";
import {PregledZahtevaZaAgenteComponent} from "./components/pregled-zahteva-za-agente/pregled-zahteva-za-agente.component";
import {AdminAddAgentComponent} from "./components/admin-add-agent/admin-add-agent.component";


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
  {path: 'navbaradmin', component: NavbaradminComponent},
  {path: 'neprikladansadrzaj', component:NeprikladansadrzajComponent},
  {path: 'regAgent', component:RegistracijaAgentaComponent},
  {path: 'zahteviZaAgente', component:PregledZahtevaZaAgenteComponent},
  {path: 'dodajAgenta', component:AdminAddAgentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
