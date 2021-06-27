import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {

  private newsfeedUrl : string;

  constructor(private http: HttpClient) {
    this.newsfeedUrl = 'http://localhost:8083/sadrzaj/uploadzahtev';
  }

  upload(file: any) {
    console.log('g')
    return this.http.post<any>(this.newsfeedUrl,  file, { observe: 'response' });
  }
}
