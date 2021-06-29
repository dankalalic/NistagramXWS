import { Component, OnInit } from '@angular/core';
import {Id} from "../../model/id";
import {PostService} from "../../services/post.service";

@Component({
  selector: 'app-dislajkovano',
  templateUrl: './dislajkovano.component.html',
  styleUrls: ['./dislajkovano.component.css']
})
export class DislajkovanoComponent implements OnInit {

  public contents : any = [];
  constructor(private postService:PostService) { }

  ngOnInit(): void {
    const id : Id = {
      id : 2
    };
    this.postService.getDislajkovano().subscribe(result =>
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
