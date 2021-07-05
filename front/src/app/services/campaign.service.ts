import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserLogin} from "../model/user-login";
import {JednokratnaKampanja} from "../model/jednokratna-kampanja";

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
  private uploadUrl : string;
  private getProizvodiUrl : string;

  constructor(private http: HttpClient) {
    this.createCampaignUrl = 'http://localhost:8085/jednokratneKampanje/create';
    this.uploadUrl = 'http://localhost:8083/sadrzaj/upload';
    this.getProizvodiUrl = 'http://localhost:8088/proizvod/getByAgent'
  }

  create(kampanja: JednokratnaKampanja) {
    return this.http.post<any>(this.createCampaignUrl, kampanja, options);
  }

  upload(file: any) {
    return this.http.post<any>(this.uploadUrl,  file, { observe: 'response' });
  }

  getByAgent() {
    return this.http.get<any>(this.getProizvodiUrl, options);
  }
}
