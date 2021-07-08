import {Component, Input, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {DomSanitizer} from "@angular/platform-browser";
import {ActivatedRoute, Router} from "@angular/router";
import {ProizvodService} from "../../services/proizvod.service";
import {Id} from "../../model/id";

@Component({
  selector: 'app-prikazproizvodauser',
  templateUrl: './prikazproizvodauser.component.html',
  styleUrls: ['./prikazproizvodauser.component.css']
})
export class PrikazproizvodauserComponent implements OnInit {
  @Input() zahtevi! : [];
  id! : number;
  private routeSub!: Subscription;
  constructor(private sanitizer:DomSanitizer, private router: Router, private zahtev:ProizvodService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params: { [x: string]: any; }) => {
      console.log(params) //log the entire params object
      this.id=params['id'];
      console.log(params['id']) //log the value of id
    });

    if (sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }

    const id1 : Id = {
      id : this.id
    }
    this.zahtev.getProizvodiUser(id1).subscribe(result =>
    {
      console.log('success', result);
      this.zahtevi = result;
    }, err => {
      console.log('err', err);
    })

  }

  ngOnDestroy() {
    this.routeSub.unsubscribe();
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }


  kupi(id : number) {
    const id1 : Id = {
      id : id
    }
    console.log(id1)
    this.zahtev.kupiProizvod(id1).subscribe(result =>
    {
      console.log('success', result);
      this.zahtevi = result;
    }, err => {
      console.log('err', err);
    })
  }
}
