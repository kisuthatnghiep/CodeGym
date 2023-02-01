import { Component } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
// @ts-ignore
import Swal from 'sweetalert2/dist/sweetalert2.js';
@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent {
productForm: FormGroup = new FormGroup({
  id: new FormControl(),
  name: new FormControl(),
  price: new FormControl(),
  description: new FormControl(),
})
  constructor(private productService: ProductService) {
  }
  submit(){
  const product = this.productForm.value;
  this.productService.create(product);
  this.productForm.reset();

  this.confirmSuccess()
  }
  confirmSuccess(){
    Swal.fire(
      'Good job!',
      'You clicked the button!',
      'success'
    )
  }
}
