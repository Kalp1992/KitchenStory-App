import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { IUser } from './user';
const Customer_signUp_API = 'http://localhost:8085/api/customer/';
const Customer_AUTH_API = 'http://localhost:8085/api/customer/';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})


export class CustomerServiceService {

  constructor(private http: HttpClient) { }
 
}
