import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HelperService } from '../service/helper.service';
import { Location } from '@angular/common';
@Component({
  selector: 'app-addeditemp',
  templateUrl: './addeditemp.component.html',
  styleUrls: ['./addeditemp.component.css']
})
export class AddeditempComponent implements OnInit {
  msg:any="";
  respmsg:any="";
  errordetail:any={};
    Employee:any={'emp_id':'','first_name':''};
  empid:any;
  constructor(private helperSvc :HelperService,private location: Location,private actroute:ActivatedRoute) {
    this.empid=this.actroute.snapshot.queryParamMap.get("id");
    console.log("id "+this.actroute.snapshot.queryParamMap.get("id"));
    this.helperSvc.getEmployeeByID(this.empid).subscribe((response)=>{
     
      console.log(response);
      this.Employee=response;
     // window.alert(response.msg);
    },(error:HttpErrorResponse)=>{
     this.msg=error.error.msg;
    } );
   }

  ngOnInit(): void {
  
  }
  onSubmit(){
    //console.log(obj.value);
    this.errordetail={};
    console.log(this.Employee);
    this.helperSvc.updateEmp(this.Employee).subscribe((response)=>{
     
      console.log(response);
      this.respmsg=response;
      this.msg= this.respmsg.msg;
     // window.alert(response.msg);
    },(error:HttpErrorResponse)=>{
      //error
     //error
    
     error.error.forEach((element:any) => {
      this.errordetail[element.field]=element.defaultMessage
    });
    console.log(this.errordetail);
    this.msg= error.error.msg;
    } );
  }
  cancel() {
    this.location.back(); // <-- go back to previous location on cancel
  }
}
