import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserLogin} from "../model/user-login";
import {JednokratnaKampanja} from "../model/jednokratna-kampanja";
import {Visekratna} from "../model/visekratna";
import {Id} from "../model/id";

const token = (sessionStorage.getItem('token'));
let token1 : string;
if (token != null) {token1 = token;} else {token1 = 'null';}
console.log(token1)
const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + token1,
    'Access-Control-Allow-Origin':'*'
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
  private changeJednokratnaUrl : string;
  private changeVisekratnaUrl : string;
  private deleteJednokratnaUrl : string;
  private deleteVisekratnaUrl : string;

  constructor(private http: HttpClient) {
    this.createCampaignUrl = 'http://localhost:8085/jednokratneKampanje/create';
    this.createVisekratnaCampaignUrl = 'http://localhost:8085/visekratneKampanja/create';
    this.uploadUrl = 'http://localhost:8083/sadrzaj/upload';
    this.getProizvodiUrl = 'http://localhost:8088/proizvod/getByAgent'
    this.getJednokratneUrl = 'http://localhost:8085/jednokratneKampanje/getAll';
    this.getVisekratneUrl = 'http://localhost:8085/visekratneKampanja/getAll';
    this.changeJednokratnaUrl = 'http://localhost:8085/jednokratneKampanje/change';
    this.changeVisekratnaUrl = 'http://localhost:8085/visekratneKampanja/change';
    this.deleteJednokratnaUrl = 'http://localhost:8085/jednokratneKampanje/delete';
    this.deleteVisekratnaUrl = 'http://localhost:8085/visekratneKampanja/delete';
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

  changeJednokratna(kampanja: JednokratnaKampanja) {
    return this.http.post<any>(this.changeJednokratnaUrl, kampanja, options);
  }

  changeVisekratna(kampanja : Visekratna) {
    return this.http.post<any>(this.changeVisekratnaUrl, kampanja, options);
  }

  deleteJednokratna(id : Id) {
    return this.http.post<any>(this.deleteJednokratnaUrl, id, options);
  }

  deleteVisekratna(id : Id) {
    return this.http.post<any>(this.deleteVisekratnaUrl, id, options);
  }

  upload(file: any) {
    return this.http.post<any>(this.uploadUrl,  file, { observe: 'response' });
  }

  getByAgent() {
    return this.http.get<any>(this.getProizvodiUrl, options);
  }
}
