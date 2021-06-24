import { Component, OnInit } from '@angular/core';
import { RegisteredUser } from '../../model/registeredUser';
import { ImagesService } from '../../services/images.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: RegisteredUser[] | undefined;

  constructor(private userService: ImagesService) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }
}
