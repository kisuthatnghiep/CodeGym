import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TourListComponent} from "./tour-list/tour-list.component";
import {TourDetailComponent} from "./tour-detail/tour-detail.component";

const routes: Routes = [
  {
    path: '',
    component: TourListComponent
  },{
    path: 'detail/:id',
    component: TourDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
