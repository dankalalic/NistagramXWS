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

  //private token : string | null;

  constructor(private http: HttpClient, private authService : AuthService) {
    //this.token = sessionStorage.getItem("token");
    this.newsfeedUrl = 'http://localhost:8083/sadrzaj/findByProfil';
    this.likeUrl = 'http://localhost:8083/sadrzaj/like';
    this.dislikeUrl = 'http://localhost:8083/sadrzaj/dislike';
  }

  getNewsfeed(string : StringDTO) {

    //const token1 : Stringnull = {
      //string : this.token
    //};

    return this.http.post<any>(this.newsfeedUrl, string, options);
  }

  like(id : Id) {
    return this.http.post<any>(this.likeUrl, id, options);
  }

  dislike(id : Id) {
    return this.http.post<any>(this.dislikeUrl, id, options);
  }

}
