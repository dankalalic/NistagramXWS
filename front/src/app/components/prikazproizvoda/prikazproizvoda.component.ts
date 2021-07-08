import {Component, Input, OnInit} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {ActivatedRoute, Router} from "@angular/router";
import {RegistracijaAgentaService} from "../../services/registracija-agenta.service";
import {ProizvodService} from "../../services/proizvod.service";
import {Id} from "../../model/id";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-prikazproizvoda',
  templateUrl: './prikazproizvoda.component.html',
  styleUrls: ['./prikazproizvoda.component.css']
})
export class PrikazproizvodaComponent implements OnInit {

  @Input() zahtevi! : [];
  @Input() id : number | undefined;
  isAgent! : boolean;
  private routeSub!: Subscription;
  constructor(private sanitizer:DomSanitizer, private router: Router, private zahtev:ProizvodService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params: { [x: string]: any; }) => {
      console.log(params) //log the entire params object
      console.log(params['id']) //log the value of id
    });

    if (sessionStorage.getItem("role") != "agent" && sessionStorage.getItem("role") != "user") {
      this.router.navigate(['error']);
    }

    if (sessionStorage.getItem("role") == "agent") {
      this.isAgent=true;
      this.zahtev.getProizvodi().subscribe(result =>
      {
        console.log('success', result);
        this.zahtevi = result;
      }, err => {
        console.log('err', err);
      })
    } else if (sessionStorage.getItem("role") == "user") {
      this.isAgent=false;
      //if (this.id != undefined) {
        const id1 : Id = {
          id : 2
        }
        this.zahtev.getProizvodiUser(id1).subscribe(result =>
        {
          console.log('success', result);
          this.zahtevi = result;
        }, err => {
          console.log('err', err);
        })
      //}
    }
  }

  ngOnDestroy() {
    this.routeSub.unsubscribe();
  }

  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }

  delete(id : number) {
    const id1 : Id = {
      id : id
    }
    console.log(id1)
    this.zahtev.deleteProizvod(id1).subscribe(result =>
    {
      console.log('success', result);
      this.zahtevi = result;
    }, err => {
      console.log('err', err);
    })
  }

  izmeni(id : number) {
    const id1 : Id = {
      id : id
    }
    console.log(id1)
    this.zahtev.deleteProizvod(id1).subscribe(result =>
    {
      console.log('success', result);
      this.zahtevi = result;
    }, err => {
      console.log('err', err);
    })
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
