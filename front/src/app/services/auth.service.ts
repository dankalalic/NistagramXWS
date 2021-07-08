import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import {UserLogin} from '../model/user-login'
import {HttpClientModule} from '@angular/common/http';
import {UserTokenRole} from "../model/user-token-role";
import {Stringnull} from "../model/stringnull";
import {StringDTO} from "../model/stringDTO";
import {UserSignup} from "../model/user-signup";
import {UserChange} from "../model/user-change";

const token = (sessionStorage.getItem('token'));
let token1 : string;
if (token != null) {token1 = token;} else {token1 = 'null';}
console.log(token1)
const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + token1
  }),
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl : string;
  private isExpiredUrl : string;
  private ugasiProfilKorisnika: string;
  private registrationUrl : string;
  private changeProfileUrl : string;
  private changePrivacyUrl : string;
  private profileUrl : string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8090/auth/login';
    this.isExpiredUrl = 'http://localhost:8090/auth/checkToken';
    this.ugasiProfilKorisnika = 'http://localhost:8090/users/ugasiProfil';
    this.registrationUrl = 'http://localhost:8084/registeredUsers/signup';
    this.changeProfileUrl = 'http://localhost:8084/registeredUsers/changeRegisteredUserInfo';
    this.changePrivacyUrl = 'http://localhost:8084/registeredUsers/privacySettings';
    this.profileUrl = 'http://localhost:8085/users/changeProfile';
  }

  login(user: UserLogin) {
    return this.http.post<any>(this.loginUrl, user, options);
  }

  isExpired(string : Stringnull) {
    return this.http.post<any>(this.isExpiredUrl, string, options);
  }

  ugasiProfil(username:StringDTO){
    console.log('ok')
    return this.http.post<any>(this.ugasiProfilKorisnika, username, options);
  }

  signup(user : UserSignup){
    console.log('ok')
    return this.http.post<any>(this.registrationUrl, user, options);
  }

  changeProfil(user : UserSignup){
    console.log('ok')
    return this.http.post<any>(this.changeProfileUrl, user, options);
  }

  changePrivacy(user : UserChange){
    console.log('ok')
    return this.http.post<any>(this.changePrivacyUrl, user, options);
  }

  profile(){
    console.log('ok')
    return this.http.get<any>(this.changePrivacyUrl, options);
  }

}
