import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Id} from "../model/id";
import {Post} from "../model/post";

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
export class PostserviceService {

  private newsfeedUrl : string;

  constructor(private http: HttpClient) {
    this.newsfeedUrl = 'http://localhost:8083/posts/createposts';
  }

  createPost(post:Post) {
    console.log('g')
    return this.http.post<any>(this.newsfeedUrl,post,options);
  }

}
