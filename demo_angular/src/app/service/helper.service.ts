//helper.service.ts
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({providedIn: 'root'})
export class HelperService {
 
  url = "http://localhost:8086";
 
  constructor(private http: HttpClient) {
    
  }
  getEmployee() {
    return this.http.get(this.url+'/employees')
  }

  getEmployeeByID(id:any) {
    return this.http.get(this.url+'/employee/'+id)
  }
  getemployeefilter(empName:any,gender:any) {
    return this.http.get(this.url+'/employeefilter?empname='+empName+'&gender='+gender);
  }

  newEmployee(body:any) {
    return this.http.post(this.url+'/employee',body);
  }

  getEmployeeHistory(id:any) {
    return this.http.get(this.url+'/employeehistory/'+id);
  }

  updateEmp(body:any){
    return this.http.put(this.url+'/employee',body);
  }

 deleteEmployee(id:any) {
    return this.http.delete(this.url+'/employee/'+id);
  }

  getReport():Observable<any> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Accept', 'application/json');
 
return this.http.post(this.url + '/download',"", {  responseType: 'blob', headers });
  
  }
}