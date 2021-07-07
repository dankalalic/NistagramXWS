import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar-agent',
  templateUrl: './navbar-agent.component.html',
  styleUrls: ['./navbar-agent.component.css']
})
export class NavbarAgentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  logout() {
    sessionStorage.setItem('token', '');
  }

}
