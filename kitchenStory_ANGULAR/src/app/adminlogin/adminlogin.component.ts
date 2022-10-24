import { Component, OnInit } from '@angular/core';
import {FormGroup , FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  public loginForm!:FormGroup;
  constructor(private formBuilder:FormBuilder, private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      Adminname:[''],
      password:['']
    })
  }

  login(){
 this.http.get<any>("http://localhost:8085/api/admin/all")
   .subscribe( res => {
    const admin= res.find((a:any) =>{
      return a.adminName === this.loginForm.value.Adminname &&  a.password === this.loginForm.value.password;
    });
    if(admin){
      alert("Login success");
      this.loginForm.reset();
      this.router.navigate(['admindashboard']);
    } else{
      alert("Admin not found");
    }

   }, err =>{
     alert("something went wrong !!")
   }

   );
 
  }
  


}