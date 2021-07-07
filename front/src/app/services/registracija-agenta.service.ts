import { Injectable } from '@angular/core';
import {regAgentDTO} from "../model/regAgentDTO";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Id} from "../model/id";

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
export class RegistracijaAgentaService {

  private registracija : string;
  private prihvatiZahtev: string;
  private odbijZahtev: string;
  private getZahteve: string;


  constructor(private http: HttpClient) {
    this.registracija = 'http://localhost:8084/zahteviZaRegistraciju/regAgent';
    this.getZahteve = 'http://localhost:8084/zahteviZaRegistraciju/getZahteve';
    this.prihvatiZahtev = 'http://localhost:8084/zahteviZaRegistraciju/prihvati';
    this.odbijZahtev = 'http://localhost:8084/zahteviZaRegistraciju/odbij';
  }

  createRegistracija(registracija:regAgentDTO){
    console.log('ok');
    return this.http.post<any>(this.registracija, registracija, options);
  }

  getZahtevi(){
    console.log('ok');
    return this.http.get<any>(this.getZahteve, options);
  }

  prihvati(id:Id){
    console.log('ok');
    return this.http.post<any>(this.prihvatiZahtev, id, options);
  }

  odbij(id:Id){
    console.log('ok');
    return this.http.post<any>(this.odbijZahtev, id, options);
  }


}
