import { Component, OnInit } from '@angular/core';
import {Id} from "../../model/id";
import {PostService} from "../../services/post.service";
import {CampaignService} from "../../services/campaign.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dislajkovano',
  templateUrl: './dislajkovano.component.html',
  styleUrls: ['./dislajkovano.component.css']
})
export class DislajkovanoComponent implements OnInit {

  public contents : any = [];
  constructor(private postService:PostService, private router: Router) { }

  ngOnInit(): void {

    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }

    this.postService.getDislajkovano().subscribe(result =>
    {
      this.contents = result;
      console.log('success', result);
    }, err => {
      this.router.navigate(['/error']);
    })
  }

}
