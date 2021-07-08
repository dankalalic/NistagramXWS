import { Component, OnInit } from '@angular/core';
import {porukaSadrzaj} from "../../model/porukaSadrzaj";
import {ContentService} from "../../services/content.service";
import {PostService} from "../../services/post.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";
import {tekstualnaPorukaSadrzaj} from "../../model/tekstualnaPorukaSadrzaj";

@Component({
  selector: 'app-poruka',
  templateUrl: './poruka.component.html',
  styleUrls: ['./poruka.component.css']
})
export class PorukaComponent implements OnInit {

  primalac!:number;
  tekst!:any;

  constructor(private contentService : ContentService, private postService:PostService, private sanitizer:DomSanitizer, private router: Router) {
  }
  ngOnInit(): void {
  }


  send(idPosaljioca:number) {
    const id1 : tekstualnaPorukaSadrzaj = {
      idPosaljioca:idPosaljioca,
      idPrimaoca : this.primalac,
      tekstPoruke: this.tekst
    }
    console.log(this.primalac)
    this.contentService.sendTekst(id1).subscribe(result => {
      console.log(result)
    }, err => {
      this.router.navigate(['/error']);
    })
  }

}
