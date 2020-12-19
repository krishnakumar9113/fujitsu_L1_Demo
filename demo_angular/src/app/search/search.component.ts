import { Component, OnInit } from '@angular/core';
import { HelperService } from '../service/helper.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  Employees:any=[];
  constructor(private helperSvc:HelperService) { }

  ngOnInit(): void {
    this.helperSvc.getEmployee().subscribe((response)=>{
      console.log(response);
     this.Employees= response;
    },(error)=>{} );
  }
  deleteconf(id:any){
 
 if (window.confirm("Are you sure to delete") ){
    console.log("ok");
  } else {
    console.log("cancel");
  }
  }
}
