import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addeditemp',
  templateUrl: './addeditemp.component.html',
  styleUrls: ['./addeditemp.component.css']
})
export class AddeditempComponent implements OnInit {

  constructor(private actroute:ActivatedRoute) {

    console.log("id "+this.actroute.snapshot.queryParamMap.get("id"));
   }

  ngOnInit(): void {
  }

}
