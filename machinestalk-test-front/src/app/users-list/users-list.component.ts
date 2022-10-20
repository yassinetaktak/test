import { Component, OnInit } from '@angular/core';
import {User} from "../Model/User";
import {UserServiceService} from "../user-service.service";

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
  users: User[] = [];
  constructor(private userService: UserServiceService) { }

  ngOnInit(): void {

    this.userService.getUsers().subscribe(
      data => this.users = data
    )
    console.log(this.users)
  }

}
