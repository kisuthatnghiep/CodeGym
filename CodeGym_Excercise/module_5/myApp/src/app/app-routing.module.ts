import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductListComponent} from "./product/product-list/product-list.component";
import {ProductCreateComponent} from "./product/product-create/product-create.component";
import {ProductUpdateComponent} from "./product/product-update/product-update.component";
import {DictionaryPageComponent} from "./dictionary-page/dictionary-page.component";
import {DictionaryDetailComponent} from "./dictionary-detail/dictionary-detail.component";

const routes: Routes = [
  {
<<<<<<< HEAD
    path: 'product/list',
    component: ProductListComponent
  }, {
    path: 'product/create',
    component: ProductCreateComponent
  }, {
    path: 'product/update/:id',
    component: ProductUpdateComponent
=======
    path: 'dictionary/list',
    component: DictionaryPageComponent
  },{
    path: 'dictionary/list/word/:word',
    component: DictionaryDetailComponent
>>>>>>> ab3b6c22a041e49db30da71954b851e720847b98
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
