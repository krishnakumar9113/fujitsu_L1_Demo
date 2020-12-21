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
  msg:any="";
  respmsg:any="";
  errordetail:any={};
  
  constructor(private helperSvc :HelperService,private location: Location) { }

  ngOnInit(): void {
  }
  onSubmit(obj:any){
    this.errordetail={};
    console.log(obj.value);
    this.helperSvc.newEmployee(obj.value).subscribe((response)=>{
     
      console.log(response);
      this.respmsg=response;
      this.msg= this.respmsg.msg;
    
     // window.alert(response.msg);
    },(error:HttpErrorResponse)=>{
      //error
      console.log(error);
     
      error.error.forEach((element:any) => {
       
        this.errordetail[element.field]=element.defaultMessage
      });
      console.log(this.errordetail); this.msg= error.error.msg;
    } );
  }


    cancel() {
      this.location.back(); // <-- go back to previous location on cancel
    }
}
