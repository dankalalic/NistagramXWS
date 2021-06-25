import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginFormComponent} from "./components/login-form/login-form.component";
import {AppComponent} from "./app.component";
import {ContentComponent} from "./components/content/content.component";
import {AuthService} from "./services/auth.service";
import {NewsfeedComponent} from "./components/newsfeed/newsfeed.component";
import {ProfileViewComponent} from "./components/profile-view/profile-view.component";

const routes: Routes = [
  { path: '', component: LoginFormComponent},
  { path: 'newsfeed', component: NewsfeedComponent},
  { path: 'profile', component: ProfileViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
