//helper.service.ts
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
 
@Injectable({providedIn: 'root'})
export class HelperService {
 
  url = "http://localhost:8086";
 
  constructor(private http: HttpClient) {
    
  }
  getEmployee() {
    return this.http.get(this.url+'/employees')
  }

  newEmployee(body:any) {
    return this.http.post(this.url+'/employees',body);
  }
}