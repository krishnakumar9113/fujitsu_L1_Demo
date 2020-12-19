import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddeditempComponent } from './addeditemp/addeditemp.component';
import { EmphistoryComponent } from './emphistory/emphistory.component';
import { NewempComponent } from './newemp/newemp.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path :'search',component:SearchComponent},
  {path :'addeditemp',component:AddeditempComponent},
  {path :'emphist',component:EmphistoryComponent},
  {path :'addemp',component:NewempComponent},
  { path: '', redirectTo: 'search', pathMatch: 'full' }, //default screen

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
