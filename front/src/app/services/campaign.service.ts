import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserLogin} from "../model/user-login";
import {JednokratnaKampanja} from "../model/jednokratna-kampanja";
import {Visekratna} from "../model/visekratna";

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
export class CampaignService {

  private createCampaignUrl : string;
  private createVisekratnaCampaignUrl : string;
  private uploadUrl : string;
  private getProizvodiUrl : string;
  private getJednokratneUrl : string;
  private getVisekratneUrl : string;

  constructor(private http: HttpClient) {
    this.createCampaignUrl = 'http://localhost:8085/jednokratneKampanje/create';
    this.createVisekratnaCampaignUrl = 'http://localhost:8085/visekratneKampanja/create';
    this.uploadUrl = 'http://localhost:8083/sadrzaj/upload';
    this.getProizvodiUrl = 'http://localhost:8088/proizvod/getByAgent'
    this.getJednokratneUrl = 'http://localhost:8085/jednokratneKampanje/getAll';
    this.getVisekratneUrl = 'http://localhost:8085/visekratneKampanja/getAll';
  }

  create(kampanja: JednokratnaKampanja) {
    return this.http.post<any>(this.createCampaignUrl, kampanja, options);
  }

  createVisekatna(kampanja: Visekratna) {
    return this.http.post<any>(this.createVisekratnaCampaignUrl, kampanja, options);
  }

  getJednokratne() {
    return this.http.get<any>(this.getJednokratneUrl, options);
  }

  getVisekratne() {
    return this.http.get<any>(this.getVisekratneUrl, options);
  }

  upload(file: any) {
    return this.http.post<any>(this.uploadUrl,  file, { observe: 'response' });
  }

  getByAgent() {
    return this.http.get<any>(this.getProizvodiUrl, options);
  }
}
