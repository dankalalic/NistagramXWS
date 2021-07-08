import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Id} from "../model/id";
import {StringDTO} from "../model/stringDTO";

const options1 = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

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

export class SearchService {

  private profileUrl : string;
  private locationUrl : string;
  private tagsUrl : string;
  private profileUrlNotLogged : string;
  private locationUrlNotLogged : string;
  private tagsUrlNotLogged : string;

  constructor(private http: HttpClient) {
    this.profileUrl = 'http://localhost:8083/sadrzaj/findByProfil';
    this.locationUrl = 'http://localhost:8083/sadrzaj/findByLokacija';
    this.tagsUrl = 'http://localhost:8083/sadrzaj/findByTag';
    this.profileUrlNotLogged = 'http://localhost:8083/sadrzaj/findByProfilNotLogged';
    this.locationUrlNotLogged = 'http://localhost:8083/sadrzaj/findByLokacijaNotLogged';
    this.tagsUrlNotLogged = 'http://localhost:8083/sadrzaj/findByTagNotLogged';
  }

  getByProfile(string : StringDTO) {
    return this.http.post<any>(this.profileUrl, string, options);
  }

  getByLocation(string : StringDTO) {
    return this.http.post<any>(this.locationUrl, string, options);
  }

  getByTag(string : StringDTO) {
    return this.http.post<any>(this.tagsUrl, string, options);
  }

  getByProfileNotLogged(string : StringDTO) {
    return this.http.post<any>(this.profileUrlNotLogged, string, options);
  }

  getByLocationNotLogged(string : StringDTO) {
    return this.http.post<any>(this.locationUrlNotLogged, string, options);
  }

  getByTagNotLogged(string : StringDTO) {
    return this.http.post<any>(this.tagsUrlNotLogged, string, options);
  }
}
