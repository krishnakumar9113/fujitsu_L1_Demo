import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HelperService } from '../service/helper.service';

@Component({
  selector: 'app-newemp',
  templateUrl: './newemp.component.html',
  styleUrls: ['./newemp.component.css']
})
export class NewempComponent implements OnInit {

  constructor(private helperSvc :HelperService) { }

  ngOnInit(): void {
  }
  onSubmit(obj:any){
    console.log(obj.value);
    this.helperSvc.newEmployee(obj.value).subscribe((response)=>{
     
      console.log(response)
    },(error:HttpErrorResponse)=>{
      //error
      error.status
    } );
  }
}
