import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../model/product";
import {ProductAngularService} from "../service/product-angular.service";
import {CategoryService} from "../service/category.service";
import {Category} from "../model/category";
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {finalize} from "rxjs";


@Component({
  selector: 'app-product-angular',
  templateUrl: './product-angular.component.html',
  styleUrls: ['./product-angular.component.css']
})
export class ProductAngularComponent implements OnInit {

  constructor(private productService: ProductAngularService,
              private categoryService: CategoryService,
              private storage: AngularFireStorage) {
  }

  productForm: FormGroup = new FormGroup({
    name: new FormControl(),
    price: new FormControl(),
    quantity: new FormControl(),
    category: new FormGroup({
      id: new FormControl()
    }),
  })

  productUpdateForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    quantity: new FormControl(),
    category: new FormGroup({
      id: new FormControl()
    }),
    img: new FormControl()
  })
  products: Product[] = []
  productPaging: Product[] = []
  categories: Category[] = []
  imageFile: any

  path!: string
  pathName!: string

  k: number = 0

  ngOnInit() {
    this.getAll()
    this.getAllCategory()
  }

  onScroll() {
    for (let i = this.k; i < this.k + 8; i++) {
      if (this.products[i] !== undefined) {
        this.productPaging[i] = this.products[i]
      } else {
        break
      }
    }
    console.log(this.productPaging)
    this.k += 8
  }

  submitAvatar(event: any) {
    this.imageFile = event.target.files[0];
    if (this.pathName !== this.imageFile.name) {
      this.pathName = this.imageFile.name
    }
  }

  filterByCategory(id: any) {
    this.k = 0
    if (id == 0) {
      this.getAll()
    } else {
      this.productService.filterByCategory(id).subscribe(data => {
        this.products = data
        this.productPaging = []
        this.onScroll()
      })
    }
  }

  createProduct() {
    if (this.imageFile !== undefined) {
      const imagePath = `image/${this.imageFile.name.split('.').slice(0, -1).join('.')}_${new Date().getTime()}`;
      const fileRef = this.storage.ref(imagePath);
      this.storage.upload(imagePath, this.imageFile).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe(url => {
            const product = this.productForm.value
            product.img = url
            this.productService.createProduct(product).subscribe(() => {
              this.productForm.reset();
              document.getElementById("btnCreate")?.click()
              this.confirmSuccess();
              this.getAll()
            })
          });
        })
      ).subscribe()
    } else {
      const product = this.productForm.value
      product.img = null
      this.productService.createProduct(product).subscribe(() => {
        this.productForm.reset();
        document.getElementById("btnCreate")?.click()
        this.confirmSuccess();
        this.getAll()
      })
    }
  }

  confirmSuccess() {
    Swal.fire(
      'Good job!',
      'You clicked the button!',
      'success'
    )
  }


  getAll() {
    this.productService.getAll().subscribe(products => {
      this.productPaging = []
      this.products = products;
      this.onScroll()
    })
  }

  searchProduct(q: string) {
    this.k = 0
    this.productPaging = []
    this.productService.searchProduct(q).subscribe(products => {
      this.products = products
      this.onScroll()
    }, () => {
      this.products = []
      this.onScroll()
    })
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories
    })
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
        this.productService.deleteProduct(id).subscribe(() => {
          Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
          )
          this.getAll()
        })
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
        category: new FormGroup({
          id: new FormControl(product.category?.id)
        }),
        img: new FormControl()
      })
    })
  }

  updateProduct() {
    if (this.imageFile !== undefined) {
      const imagePath = `image/${this.imageFile.name.split('.').slice(0, -1).join('.')}_${new Date().getTime()}`;
      const fileRef = this.storage.ref(imagePath);
      this.storage.upload(imagePath, this.imageFile).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe(url => {
            const product = this.productUpdateForm.value
            product.img = url
            this.productService.updateProduct(product.id, product).subscribe(() => {
              document.getElementById("btnCloseUpdateProduct")?.click()
              this.confirmSuccess()
              this.getAll()
            })
          });
        })
      ).subscribe()
    } else {
      const product = this.productUpdateForm.value
      product.img = null
      this.productService.updateProduct(product.id, product).subscribe(() => {
        document.getElementById("btnCloseUpdateProduct")?.click()
        this.confirmSuccess()
        this.getAll()
      })
    }
  }
}
