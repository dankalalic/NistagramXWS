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
import { SearchChoiceComponent } from './components/search-choice/search-choice.component';
import { ErrorComponent } from './components/error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    ButtonComponent,
    ContentComponent,
    NavbarComponent,
    NewsfeedComponent,
    ProfileViewComponent,
    SearchChoiceComponent,
    ErrorComponent
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
