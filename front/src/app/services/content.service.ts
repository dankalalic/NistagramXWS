import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import {HttpClientModule} from '@angular/common/http';
import {UserLogin} from "../model/user-login";
import {Id} from "../model/id";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class ContentService {

  private newsfeedUrl : string;

  constructor(private http: HttpClient) {
    this.newsfeedUrl = 'http://localhost:8083/sadrzaj/findByProfil';
  }

  getNewsfeed(id : Id) {
    console.log('g')
    return this.http.post<any>(this.newsfeedUrl, id, options);
  }
}
