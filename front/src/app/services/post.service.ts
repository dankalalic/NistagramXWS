import { Injectable } from '@angular/core';
import {Id} from '../model/id'
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserLogin} from "../model/user-login";

const options = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private contentReport : string;
  private liked : string;
  private disliked : string;

  constructor(private http: HttpClient) {
    this.contentReport = 'http://localhost:8083/sadrzaj/neprikladanSadrzaj';
    this.liked = 'http://localhost:8083/sadrzaj/sadrzajKorisnikLajkovao';
    this.disliked = 'http://localhost:8083/sadrzaj/sadrzajKorisnikDislajkovao';
  }

  report(id: Id) {
    console.log('ok')
    return this.http.post<any>(this.contentReport, id, options);
  }

  getLajkovano(id:Id){
    console.log('ok')
    return this.http.post<any>(this.liked, id, options);
  }

  getDislajkovano(id:Id){
    console.log('ok')
    return this.http.post<any>(this.disliked, id, options);
  }

}
