import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Zahtev} from "../model/zahtev";
import {Proizvod} from "../model/proizvod";
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
export class ProizvodService {

  private newsfeedUrl : string;
  private uploadslike :string;
  private proizvodi :string;
  private proizvodiIzbrisi :string;
  private proizvodiGetUser :string;
  private proizvodiIzmeni :string;
  private proizvodiKupi :string;

  constructor(private http: HttpClient) {
    this.newsfeedUrl = 'http://localhost:8088/proizvod/createproizvod';
    this.uploadslike='http://localhost:8088/proizvod/upload';
    this.proizvodi='http://localhost:8088/proizvod/getByAgent';
    this.proizvodiIzbrisi='http://localhost:8088/proizvod/izbrisiproizvod';
    this.proizvodiGetUser='http://localhost:8088/proizvod/getByAgentUser';
    this.proizvodiIzmeni='http://localhost:8088/proizvod/izmeniproizvod';
    this.proizvodiKupi='http://localhost:8088/proizvod/dodajukorpu';
  }

  createProizvod(proizvod:Proizvod) {
    console.log(proizvod)
    return this.http.post<any>(this.newsfeedUrl,proizvod,options);
  }

  upload(file: any) {
    console.log('g')
    return this.http.post<any>(this.uploadslike,  file, { observe: 'response' });
  }

  getProizvodi(){
    console.log('ok');
    return this.http.get<any>(this.proizvodi, options);
  }

  deleteProizvod(id : Id) {
    return this.http.post<any>(this.proizvodiIzbrisi, id, options);
  }

  getProizvodiUser(id : Id) {
    return this.http.post<any>(this.proizvodiGetUser, id, options);
  }

  izmeniProizvod(id : Proizvod) {
    return this.http.post<any>(this.proizvodiIzmeni, id, options);
  }

  kupiProizvod(id : Id) {
    return this.http.post<any>(this.proizvodiKupi, id, options);
  }
}
