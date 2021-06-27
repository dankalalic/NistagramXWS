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

  constructor(private searchService : SearchService, private router: Router) { }

  ngOnInit(): void {
    this.by = 'profile';
  }

  profile() {this.by = 'profile';}
  location() {this.by = 'location';}
  tags() {this.by = 'tags';}

  onSubmit() {
    const search1 : StringDTO = {
      string : this.search
    }
    if (this.by == 'profile') {
      this.getByProfile(search1);
    } else if (this.by == 'location') {
      this.getByLocation(search1);
    } else if (this.by == 'tags') {
      this.getByTag(search1);
    }
  }
  getByProfile(username : StringDTO) {
    this.searchService.getByProfile(username).subscribe(result => {
      this.contents = result;
      console.log('success', result);

    }, err => {
      console.log('err', err);
    })

    this.search = '';
  }

  getByLocation(naziv : StringDTO) {
    this.searchService.getByLocation(naziv).subscribe(result => {
      this.contents = result;
      console.log('success', result);

    }, err => {
      console.log('err', err);
    })
    this.search = '';
  }

  getByTag(naziv : StringDTO) {
    this.searchService.getByTag(naziv).subscribe(result => {
      this.contents = result;
      console.log('success', result);

    }, err => {
      console.log('err', err);
    })
    this.search = '';
  }
}
