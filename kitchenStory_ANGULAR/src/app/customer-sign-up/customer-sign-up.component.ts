import { Component, OnInit } from '@angular/core';

import {FormGroup,FormBuilder} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customer-sign-up',
  templateUrl: './customer-sign-up.component.html',
  styleUrls: ['./customer-sign-up.component.css']
})
export class CustomerSignUpComponent implements OnInit {
  
  public signupForm !: FormGroup;
  constructor(private formBuilder:FormBuilder, private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.signupForm=this.formBuilder.group({
      customerId:[''],
      name:[''],
      customername:[''],
      password:['']
    } )
  }
  signUp(){
    this.http.post<any>("http://localhost:8085/api/customer/signUp", this.signupForm.value)
      .subscribe(res => {
        alert("SignUp successfull");
        this.signupForm.reset();
        this.router.navigate(['Customerlogin']);
      }, err => {
        alert("something went wrong");
      }
      );
    
   }
  
  }
