import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Id} from "../model/id";
import {StringDTO} from "../model/stringDTO";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})

export class SearchService {

  private profileUrl : string;
  private locationUrl : string;
  private tagsUrl : string;

  constructor(private http: HttpClient) {
    this.profileUrl = 'http://localhost:8083/sadrzaj/findByProfil';
    this.locationUrl = 'http://localhost:8083/sadrzaj/findByLokacija';
    this.tagsUrl = 'http://localhost:8083/sadrzaj/findByTag';
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
}
