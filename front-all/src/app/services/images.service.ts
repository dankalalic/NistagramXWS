import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import {RegisteredUser} from '../model/registeredUser'

@Injectable({
  providedIn: 'root'
})
export class ImagesService {

  private usersUrl : string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/settings/registeredUsers/allUsers';
  }

  public findAll(): Observable<RegisteredUser[]> {
    return this.http.get<RegisteredUser[]>(this.usersUrl);
  }
}
