import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../model/product";
import {ProductAngularService} from "../service/product-angular.service";
import {CategoryService} from "../service/category.service";
import {Category} from "../model/category";

@Component({
  selector: 'app-product-angular',
  templateUrl: './product-angular.component.html',
  styleUrls: ['./product-angular.component.css']
})
export class ProductAngularComponent implements OnInit {

  constructor(private productService: ProductAngularService,
              private categoryService: CategoryService) {
  }

  productForm: FormGroup = new FormGroup({
    name: new FormControl(),
    price: new FormControl(),
    quantity: new FormControl(),
    category: new FormControl(),
    img: new FormControl()
  })

  productUpdateForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    quantity: new FormControl(),
    category: new FormControl(),
    img: new FormControl()
  })

  products: Product[] = []
  categories: Category[] = []

  confirmSuccess() {
    Swal.fire(
      'Good job!',
      'You clicked the button!',
      'success'
    )
  }

  ngOnInit(): void {
    this.getAll()
    this.getAllCategory()
  }

  getAll() {
    this.productService.getAll().subscribe(products => {
      this.products = products;
    })
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories
    })
  }

  createProduct() {
    const product = this.productForm.value
    this.productService.createProduct(product).subscribe(() => {
      this.productForm.reset()
      this.confirmSuccess()
      this.getAll()
    });
  }

  deleteProduct(id: any) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result: { isConfirmed: any; }) => {
      if (result.isConfirmed) {
        this.productService.deleteProduct(id).subscribe()
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
        this.getAll()
      }
    })

  }

  getProduct(id: any) {
    this.productService.findById(id).subscribe(product => {
      this.productUpdateForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        quantity: new FormControl(product.quantity),
        category: new FormControl(product.category?.id),
        img: new FormControl()
      })
    })
  }

  updateProduct() {
    const product = this.productUpdateForm.value
    this.productService.updateProduct(product.id, product).subscribe(() =>{
      document.getElementById("btnCloseUpdateProduct")?.click()
      this.confirmSuccess()
      this.getAll()
    })
  }
}
