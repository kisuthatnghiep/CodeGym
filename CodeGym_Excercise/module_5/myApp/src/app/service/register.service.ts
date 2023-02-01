import { Injectable } from '@angular/core';
import {User1} from "../model/user1";
import {Product2} from "../model/product2";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  userList: User1[] = []
  constructor() { }
  create(user: User1) {
    this.userList.push(user)
    console.log(this.userList)
  }

  getAll(){
    return this.userList
  }
}
