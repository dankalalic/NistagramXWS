import { Component, OnInit } from '@angular/core';
import {PostService} from "../../services/post.service";

@Component({
  selector: 'app-neprikladansadrzaj',
  templateUrl: './neprikladansadrzaj.component.html',
  styleUrls: ['./neprikladansadrzaj.component.css']
})
export class NeprikladansadrzajComponent implements OnInit {

  public admincontents : any = [];
  constructor(private postService : PostService) { }

  ngOnInit(): void {
    this.postService.getNeprikladanSadrzaj().subscribe(result =>
    {
      //this.router.navigate(['/newsfeed']);
      //sessionStorage.setItem('token', result.accessToken);
      this.admincontents = result;
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
