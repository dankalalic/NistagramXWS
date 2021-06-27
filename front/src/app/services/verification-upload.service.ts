import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Id} from "../model/id";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class VerificationUploadService {



  private newsfeedUrl : string;

  constructor(private http: HttpClient) {
    this.newsfeedUrl = 'http://localhost:8083/sadrzaj/upload';
  }

  upload(file: any) {
    console.log('g')
    return this.http.post<any>(this.newsfeedUrl,  file, { observe: 'response' });
  }

}
