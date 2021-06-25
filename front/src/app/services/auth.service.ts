import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import {UserLogin} from '../model/user-login'
import {HttpClientModule} from '@angular/common/http';
import {UserTokenRole} from "../model/user-token-role";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl : string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8090/auth/login';
  }

  login(user: UserLogin) {
    console.log('g')
    return this.http.post<any>(this.loginUrl, user, options);
  }
}
