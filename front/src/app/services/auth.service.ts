import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import {UserLogin} from '../model/user-login'
import {HttpClientModule} from '@angular/common/http';
import {UserTokenRole} from "../model/user-token-role";
import {Stringnull} from "../model/stringnull";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin':'*',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl : string;
  private isExpiredUrl : string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8090/auth/login';
    this.isExpiredUrl = 'http://localhost:8090/auth/checkToken';
  }

  login(user: UserLogin) {
    return this.http.post<any>(this.loginUrl, user, options);
  }

  isExpired(string : Stringnull) {
    return this.http.post<any>(this.isExpiredUrl, string, options);
  }
}
