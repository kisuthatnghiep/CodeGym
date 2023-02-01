import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, ParamMap} from '@angular/router';
import {ProductService} from "../../service/product.service";
// @ts-ignore
import Swal from 'sweetalert2/dist/sweetalert2.js';
import {Product2} from "../../model/product2";

@Component({
  selector: 'app-product2-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent{
  productForm: FormGroup | any;
  id: number | any;

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap | any) => {
      this.id = +paramMap.get('id');
        const product: Product2 | any = this.getProduct(this.id);
      this.productForm = new FormGroup({

          id: new FormControl(product.id),

          name: new FormControl(product.name),

          price: new FormControl(product.price),

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
