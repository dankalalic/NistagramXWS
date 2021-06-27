import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Post} from "../model/post";
import {Zahtev} from "../model/zahtev";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};
@Injectable({
  providedIn: 'root'
})
export class ZahtevkreiranjeService {
  private newsfeedUrl : string;

  constructor(private http: HttpClient) {
    this.newsfeedUrl = 'http://localhost:8084/zahteviZaVerifikaciju/createzahtev';
  }

  createZahtev(zahtev:Zahtev) {
    console.log(zahtev)
    return this.http.post<any>(this.newsfeedUrl,zahtev,options);
  }
}
