import { Component, OnInit } from '@angular/core';
import {PostService} from "../../services/post.service";
import {Id} from "../../model/id";

@Component({
  selector: 'app-lajkovano',
  templateUrl: './lajkovano.component.html',
  styleUrls: ['./lajkovano.component.css']
})
export class LajkovanoComponent implements OnInit {

  public contents : any = [];
  constructor(private postService:PostService) { }

  ngOnInit(): void {
    const id : Id = {
      id : 2
    };
    this.postService.getLajkovano().subscribe(result =>
    {
      //this.router.navigate(['/newsfeed']);
      //sessionStorage.setItem('token', result.accessToken);
      this.contents = result;
      /*for (let content of this.contents) {
        for(let image of content.slike) {
          this.images.push(image)
        }
      }*/
      console.log('success', result);

    }, err => {
      console.log('err', err);
    })
  }

}
