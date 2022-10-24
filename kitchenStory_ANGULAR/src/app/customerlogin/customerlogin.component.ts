import { Component, OnInit } from '@angular/core';
import { CustomerServiceService} from '../customer-service.service';
import {FormGroup , FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit {
  public loginForm!:FormGroup;
  constructor(private formBuilder:FormBuilder, private http:HttpClient, private router:Router ) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      customername:[''],
      password:['']
    })
  }
  login(){
    this.http.get<any>("http://localhost:8085/api/customer/all")
      .subscribe( res => {
       const user= res.find((a:any) =>{
         return a.customerName === this.loginForm.value.customername &&  a.password === this.loginForm.value.password;
       });
       if(user){
         alert("Login success");
         this.loginForm.reset();
         this.router.navigate(['customerdashboard']);
       } else{
         alert("Customer not found");
       }
   
      }, err =>{
        alert("something went wrong !!")
      }
   
      );
    
     }
     
  }