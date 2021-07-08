import { Component, OnInit } from '@angular/core';
import {SearchService} from "../../services/search.service";
import {Router} from "@angular/router"
import {AuthService} from "../../services/auth.service";
import {StringDTO} from "../../model/stringDTO";

@Component({
  selector: 'app-search-choice',
  templateUrl: './search-choice.component.html',
  styleUrls: ['./search-choice.component.css']
})

export class SearchChoiceComponent implements OnInit {

  public contents : any = [];
  public by! : string;
  public search! : string;
  public empty! : boolean;
  public isForProfile : boolean = true;
  isLogged : any;

  constructor(private searchService : SearchService, private router: Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('role') == "user") {this.isLogged=true;}
    else if (sessionStorage.getItem('role') == "agent") { this.isLogged=true;}
    else {this.isLogged=false;}

    this.by = 'profile';
  }

  profile() {this.by = 'profile';}
  location() {this.by = 'location';}
  tags() {this.by = 'tags';}

  onSubmit() {
    const search1 : StringDTO = {
      string : this.search
    }
    if(this.isLogged==true) {
      if (this.by == 'profile') {
        this.getByProfile(search1);
      } else if (this.by == 'location') {
        this.getByLocation(search1);
      } else if (this.by == 'tags') {
        this.getByTag(search1);
      }
    } else {
      if (this.by == 'profile') {
        this.getByProfileNotLogged(search1);
      } else if (this.by == 'location') {
        this.getByLocationNotLogged(search1);
      } else if (this.by == 'tags') {
        this.getByTagNotLogged(search1);
      }
    }
  }

  getByProfile(username : StringDTO) {
    this.searchService.getByProfile(username).subscribe(result => {
      this.contents = result;
      this.empty = this.contents.length == 0;
      this.isForProfile = true;
      //this.empty = !!this.contents.empty;
      console.log('success', result);

    }, err => {
      this.router.navigate(['/error']);
    })
    this.search = '';
  }

  getByLocation(naziv : StringDTO) {
    this.searchService.getByLocation(naziv).subscribe(result => {
      this.contents = result;
      this.empty = this.contents.length == 0;
      this.isForProfile = false;
      console.log('success', result);
    }, err => {
      this.router.navigate(['/error']);
    })
    this.search = '';
  }

  getByTag(naziv : StringDTO) {
    this.searchService.getByTag(naziv).subscribe(result => {
      this.contents = result;
      this.empty = this.contents.length == 0;
      this.isForProfile = false;
      console.log('success', result);

    }, err => {
      this.router.navigate(['/error']);
    })
    this.search = '';
  }

  getByProfileNotLogged(username : StringDTO) {
    this.searchService.getByProfileNotLogged(username).subscribe(result => {
      this.contents = result;
      this.empty = this.contents.length == 0;
      this.isForProfile = true;
      //this.empty = !!this.contents.empty;
      console.log('success', result);

    }, err => {
      this.router.navigate(['/error']);
    })
    this.search = '';
  }

  getByLocationNotLogged(naziv : StringDTO) {
    this.searchService.getByLocationNotLogged(naziv).subscribe(result => {
      this.contents = result;
      this.empty = this.contents.length == 0;
      this.isForProfile = false;
      console.log('success', result);
    }, err => {
      this.router.navigate(['/error']);
    })
    this.search = '';
  }

  getByTagNotLogged(naziv : StringDTO) {
    this.searchService.getByTagNotLogged(naziv).subscribe(result => {
      this.contents = result;
      this.empty = this.contents.length == 0;
      this.isForProfile = false;
      console.log('success', result);

    }, err => {
      this.router.navigate(['/error']);
    })
    this.search = '';
  }
}
