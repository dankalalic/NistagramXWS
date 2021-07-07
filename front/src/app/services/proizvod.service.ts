import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Zahtev} from "../model/zahtev";
import {Proizvod} from "../model/proizvod";

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
export class ProizvodService {

  private newsfeedUrl : string;
  private uploadslike :string;

  constructor(private http: HttpClient) {
    this.newsfeedUrl = 'http://localhost:8088/proizvod/createproizvod';
    this.uploadslike='http://localhost:8088/proizvod/upload';
  }

  createProizvod(proizvod:Proizvod) {
    console.log(proizvod)
    return this.http.post<any>(this.newsfeedUrl,proizvod,options);
  }

  upload(file: any) {
    console.log('g')
    return this.http.post<any>(this.uploadslike,  file, { observe: 'response' });
  }
}
