import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {Directive} from "@angular/core";
import {HttpClientModule} from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { ButtonComponent } from './components/button/button.component';
import {CommonModule} from '@angular/common';
import {AuthService} from "./services/auth.service";
import { ContentComponent } from './components/content/content.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NewsfeedComponent } from './components/newsfeed/newsfeed.component';
import { ProfileViewComponent } from './components/profile-view/profile-view.component';
import { PostComponent } from './components/post/post.component';
import { VerificationUploadComponent } from './components/verification-upload/verification-upload.component';
import {ZahtevComponent} from "./components/zahtev/zahtev.component";
import { LajkovanoComponent } from './components/lajkovano/lajkovano.component';
import { DislajkovanoComponent } from './components/dislajkovano/dislajkovano.component';
import { SearchChoiceComponent } from './components/search-choice/search-choice.component';
import { ErrorComponent } from './components/error/error.component';
import { CreateCampaignComponent } from './components/create-campaign/create-campaign.component';
import { NavbarAgentComponent } from './components/navbar-agent/navbar-agent.component';
import { KampanjePregledComponent } from './components/kampanje-pregled/kampanje-pregled.component';
import { CampaignChangeComponent } from './components/campaign-change/campaign-change.component';
import { ProizvodComponent } from './components/proizvod/proizvod.component';
import { NeprikladansadrzajComponent } from './components/neprikladansadrzaj/neprikladansadrzaj.component';
import { ContentadminComponent } from './components/contentadmin/contentadmin.component';
import { RegistracijaAgentaComponent } from './components/registracija-agenta/registracija-agenta.component';
import { PregledZahtevaZaAgenteComponent } from './components/pregled-zahteva-za-agente/pregled-zahteva-za-agente.component';
import { AdminAddAgentComponent } from './components/admin-add-agent/admin-add-agent.component';
import { NavbaradminComponent } from './components/navbaradmin/navbaradmin.component';
import { NavbarNotloggedComponent } from './components/navbar-notlogged/navbar-notlogged.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ProfileChangeComponent } from './components/profile-change/profile-change.component';
import { PrikazproizvodaComponent } from './components/prikazproizvoda/prikazproizvoda.component';
import { IzmenaProizvodaComponent } from './components/izmena-proizvoda/izmena-proizvoda.component';
import { PrikazproizvodauserComponent } from './components/prikazproizvodauser/prikazproizvodauser.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    ButtonComponent,
    ContentComponent,
    NavbarComponent,
    NewsfeedComponent,
    ProfileViewComponent,
    PostComponent,
    VerificationUploadComponent,
    ZahtevComponent,
    LajkovanoComponent,
    DislajkovanoComponent,
    SearchChoiceComponent,
    ErrorComponent,
    CreateCampaignComponent,
    NavbarAgentComponent,
    KampanjePregledComponent,
    CampaignChangeComponent,
    ProizvodComponent,
    NavbaradminComponent,
    NeprikladansadrzajComponent,
    ContentadminComponent,
    RegistracijaAgentaComponent,
    PregledZahtevaZaAgenteComponent,
    AdminAddAgentComponent,
    NavbarNotloggedComponent,
    RegistrationComponent,
    ProfileChangeComponent,
    PrikazproizvodaComponent,
    IzmenaProizvodaComponent,
    PrikazproizvodauserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
