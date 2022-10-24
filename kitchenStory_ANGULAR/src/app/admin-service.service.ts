import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const Admin_AUTH_API = 'http://localhost:8082/api/admin/';
const Admin_signUp_API = 'http://localhost:8082/api/admin/';


@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(private http: HttpClient) { }
  
 
}
