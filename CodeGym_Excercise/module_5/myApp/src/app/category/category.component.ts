import {Component, OnInit} from '@angular/core';
import {Category} from "../model/category";
import {CategoryService} from "../service/category.service";
import {FormControl, FormGroup} from "@angular/forms";
// @ts-ignore
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  ngOnInit(): void {
    this.getAll()
  }

  constructor(private categoryService: CategoryService) {
  }

  categoryForm: FormGroup = new FormGroup({
    name: new FormControl()
  })
  categoryFormUpdate: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl()
  })
  categories: Category[] = [];

  getAll() {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    })
  }

  createCategory() {
    const category = this.categoryForm.value;
    this.categoryService.saveCategory(category).subscribe(() => {
      this.categoryForm.reset();
      document.getElementById("btnCreate")?.click()
      this.confirmSuccess();
      this.getAll()
    })
  }

  confirmSuccess() {
    Swal.fire(
      'Good job!',
      'You clicked the button!',
      'success'
    )
  }

  deleteCategory(id: any) {
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
        this.categoryService.deleteCategory(id).subscribe()
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
        this.getAll()
      }
    })
  }

  updateCategory() {
    const category = this.categoryFormUpdate.value
    this.categoryService.updateCategory(category.id, category).subscribe(() => {
      document.getElementById("btnUpdateCategory")?.click()
      this.confirmSuccess()
      this.getAll()
    });
  }

  getCategory(id: any) {
    return this.categoryService.findById(id).subscribe(category => {
      this.categoryFormUpdate = new FormGroup({
        id: new FormControl(category.id),
        name: new FormControl(category.name)
      })
    })
  }
}
