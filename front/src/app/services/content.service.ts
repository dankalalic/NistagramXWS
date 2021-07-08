import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import {HttpClientModule} from '@angular/common/http';
import {UserLogin} from "../model/user-login";
import {Id} from "../model/id";
import {AuthService} from "./auth.service";
import {Stringnull} from "../model/stringnull";
import {StringDTO} from "../model/stringDTO";

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
export class ContentService {

  private newsfeedUrl : string;
  private likeUrl : string;
  private dislikeUrl : string;
  private kampanjaUrl : string;
  private newsfeedUrlNotLogged : string;

  constructor(private http: HttpClient, private authService : AuthService) {
    this.newsfeedUrl = 'http://localhost:8083/sadrzaj/getAll';
    this.likeUrl = 'http://localhost:8083/sadrzaj/like';
    this.dislikeUrl = 'http://localhost:8083/sadrzaj/dislike';
    this.kampanjaUrl = 'http://localhost:8085/reklamice/getAllKampanje';
    this.newsfeedUrlNotLogged = 'http://localhost:8083/sadrzaj/getAllNotLogged';

  }

  getNewsfeed() {
    return this.http.get<any>(this.newsfeedUrl, options);
  }

  getKampanje() {
    return this.http.get<any>(this.kampanjaUrl, options);
  }

  like(id : Id) {
    return this.http.post<any>(this.likeUrl, id, options);
  }

  dislike(id : Id) {
    return this.http.post<any>(this.dislikeUrl, id, options);
  }

  getNewsfeedNotLogged() {
    return this.http.get<any>(this.newsfeedUrlNotLogged, options);
  }

}
