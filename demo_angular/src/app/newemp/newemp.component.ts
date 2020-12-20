import { HttpErrorResponse, HttpEvent, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HelperService } from '../service/helper.service';
import { Location } from '@angular/common';
@Component({
  selector: 'app-newemp',
  templateUrl: './newemp.component.html',
  styleUrls: ['./newemp.component.css']
})
export class NewempComponent implements OnInit {

  
  constructor(private helperSvc :HelperService,private location: Location) { }

  ngOnInit(): void {
  }
  onSubmit(obj:any){
    console.log(obj.value);
    this.helperSvc.newEmployee(obj.value).subscribe((response)=>{
     
      console.log(response);
    
     // window.alert(response.msg);
    },(error:HttpErrorResponse)=>{
      //error
      error.status
    } );
  }


    cancel() {
      this.location.back(); // <-- go back to previous location on cancel
    }
}
