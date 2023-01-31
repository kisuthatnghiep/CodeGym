import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
// @ts-ignore
import Swal from 'sweetalert2/dist/sweetalert2.js';
import {RegisterService} from "../service/register.service";
import {User1} from "../model/user1";
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  userList: User1[] = []
  userForm = new FormGroup({
    email: new FormControl('',[Validators.email]),
    password: new FormControl('', [Validators.minLength(6)]),
    passConfirm: new FormControl('', [Validators.minLength(6)]),
    country: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.min(19)]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl(''),
  })

  constructor(private registerService: RegisterService) {
  }
  confirmSuccess(){
    Swal.fire(
      'Good job!',
      'You clicked the button!',
      'success'
    )
  }

  submit(){
    const user: any = this.userForm.value;
    if (this.userForm.valid){
    this.registerService.create(user);
    this.userForm.reset();
    this.confirmSuccess()
    }
  }

  ngOnInit(): void {
    this.userList = this.registerService.getAll()
  }
}
