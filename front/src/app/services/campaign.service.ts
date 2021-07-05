import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserLogin} from "../model/user-login";
import {JednokratnaKampanja} from "../model/jednokratna-kampanja";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin':'*',
  }),
};


@Injectable({
  providedIn: 'root'
})
export class CampaignService {

  private createCampaignUrl : string;
  private uploadUrl : string;

  constructor(private http: HttpClient) {
    this.createCampaignUrl = 'http://localhost:8085/jednokratneKampanje/create';
    this.uploadUrl = 'http://localhost:8083/sadrzaj/upload';

  }

  create(kampanja: JednokratnaKampanja) {
    return this.http.post<any>(this.createCampaignUrl, kampanja, options);
  }

  upload(file: any) {
    return this.http.post<any>(this.uploadUrl,  file, { observe: 'response' });
  }
}
