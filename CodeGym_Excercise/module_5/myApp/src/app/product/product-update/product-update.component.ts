import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, ParamMap} from '@angular/router';
import {ProductService} from "../../service/product.service";
// @ts-ignore
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent{
  productForm: FormGroup | any;
  id: number | any;

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // @ts-ignore
      this.id = +paramMap.get('id');
        const product = this.getProduct(this.id);
      this.productForm = new FormGroup({
      // @ts-ignore
          id: new FormControl(product.id),
      // @ts-ignore
          name: new FormControl(product.name),
        // @ts-ignore
          price: new FormControl(product.price),
        // @ts-ignore
          description: new FormControl(product.description),
        });
    });
  }

  getProduct(id: number) {
    return this.productService.findById(id)
  }

  update(id: number) {
    const product = this.productForm.value;
    this.productService.update(id, product);
    this.confirmSuccess()
  }

  confirmSuccess() {
    Swal.fire(
      'Good job!',
      'You clicked the button!',
      'success'
    )
  }
}
