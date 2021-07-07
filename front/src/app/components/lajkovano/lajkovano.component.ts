import { Component, OnInit } from '@angular/core';
import {PostService} from "../../services/post.service";
import {Id} from "../../model/id";
import {Router} from "@angular/router";

@Component({
  selector: 'app-lajkovano',
  templateUrl: './lajkovano.component.html',
  styleUrls: ['./lajkovano.component.css']
})
export class LajkovanoComponent implements OnInit {

  public contents : any = [];
  constructor(private postService:PostService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }
    this.postService.getLajkovano().subscribe(result =>
    {
      this.contents = result
      console.log('success', result);
    }, err => {
      this.router.navigate(['/error']);
    })
  }

}
