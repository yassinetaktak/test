import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "./Model/User";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private  url = 'http://localhost:8085/api/listusers';
  constructor(private http : HttpClient) { }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.url).pipe(
      map(res => res));


  }
}
