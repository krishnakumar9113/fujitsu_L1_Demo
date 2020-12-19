import { Component } from '@angular/core';
import { HelperService } from './service/helper.service';
import {Employee} from './models/employee';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[HelperService]
})
export class AppComponent {

 
  constructor(public http: HttpClient, private helperService: HelperService){
  }
 
}
