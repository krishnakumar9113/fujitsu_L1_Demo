import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HelperService } from '../service/helper.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  message:any={};
  Employees:any=[];
  msg:String='';
  constructor(private helperSvc:HelperService) { }

  ngOnInit(): void {
    this.getallemployees();
  }

  getallemployees(){
    this.helperSvc.getEmployee().subscribe((response)=>{
      console.log(response);
    //  this.msg="";
      this.Employees=[];
     this.Employees= response;
    },(error)=>{
     
        this.msg= error.error.msg;
    } );
  }
  deleteconf(id:any){
 
 if (window.confirm("Are you sure to delete") ){
    console.log("ok");
    this.helperSvc.deleteEmployee(id).subscribe((response)=>{
      this.message=response;
      this.msg= this.message.msg;
      this.getallemployees();
      },(error:HttpErrorResponse)=>{
      //error
      if(error){
     
        this.msg= error.error.msg;
      }
     
      } );
      
  } else {
    console.log("cancel");
  }
 
  }

  onSubmit(obj:any){
    console.log(obj.value);
    this.msg="";
    if(obj.value.sr_emp_no!="" && obj.value.sr_emp_no!=null){
   this.helperSvc.getEmployeeByID(obj.value.sr_emp_no).subscribe((response)=>{
            console.log(response);
           
            this.Employees=[];
            this.Employees[0]=response;
    },(error:HttpErrorResponse)=>{
      //error
     console.log(error.status);
    
     this.msg= error.error.msg;
     this.Employees=[];
    } );
    }else if(obj.value.sr_gender!=''&&obj.value.sr_emp_name!=''){
        this.helperSvc.getemployeefilter(obj.value.sr_emp_name,obj.value.sr_gender).subscribe((response)=>{
          console.log(response);
        
          this.Employees=[];
          this.Employees=response;
            },(error:HttpErrorResponse)=>{
              //error
            console.log(error.status);
            this.msg= error.error.msg;
          this.Employees=[];
            } );
      }else{
       
        this.getallemployees();
      }
    

  }
}
