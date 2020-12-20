import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HelperService } from '../service/helper.service';

@Component({
  selector: 'app-emphistory',
  templateUrl: './emphistory.component.html',
  styleUrls: ['./emphistory.component.css']
})
export class EmphistoryComponent implements OnInit {
  EmployeeHistory:any=[];
  fname :any;
  lname:any;
  empid:any;
  constructor(private helperSvc:HelperService,private actroute:ActivatedRoute) {
    console.log("id "+this.actroute.snapshot.queryParamMap.get("id"));
    this.empid=this.actroute.snapshot.queryParamMap.get("id");
    console.log("fname"+this.actroute.snapshot.queryParamMap.get("fname"));
this.fname=this.actroute.snapshot.queryParamMap.get("fname");
console.log("lname"+this.actroute.snapshot.queryParamMap.get("lname"));
this.lname=this.actroute.snapshot.queryParamMap.get("lname");
   }

  ngOnInit(): void {
    this.helperSvc.getEmployeeHistory(this.empid).subscribe((response)=>{
      console.log(response);
     this.EmployeeHistory= response;
    },(error)=>{} );
  }

}
