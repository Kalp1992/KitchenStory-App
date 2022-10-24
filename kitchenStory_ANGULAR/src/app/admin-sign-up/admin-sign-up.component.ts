import { Component, OnInit } from '@angular/core';
import {FormGroup,FormBuilder} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-sign-up',
  templateUrl: './admin-sign-up.component.html',
  styleUrls: ['./admin-sign-up.component.css']
})
export class AdminSignUpComponent implements OnInit {
  public signupForm !: FormGroup;
  constructor(private formBuilder:FormBuilder, private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.signupForm=this.formBuilder.group({
      adminId:[''],
      Name:[''],
      adminName:[''],
      password:['']
    } )
  }
  signUp(){
   this.http.post<any>("http://localhost:8085/api/admin/signUp", this.signupForm.value)
     .subscribe(res => {
       alert("SignUp successfull");
       this.signupForm.reset();
       this.router.navigate(['Adminlogin']);
     }, err => {
       alert("something went wrong");
     }
     );
   
  }
 
   
}
  

