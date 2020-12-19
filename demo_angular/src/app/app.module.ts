import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HelperService } from './service/helper.service';
import { HttpClientModule } from '@angular/common/http';
import { SearchComponent } from './search/search.component';
import { EmphistoryComponent } from './emphistory/emphistory.component';
import { AddeditempComponent } from './addeditemp/addeditemp.component';
import { NewempComponent } from './newemp/newemp.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    EmphistoryComponent,
    AddeditempComponent,
    NewempComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [HelperService],
  bootstrap: [AppComponent]
})
export class AppModule { }
