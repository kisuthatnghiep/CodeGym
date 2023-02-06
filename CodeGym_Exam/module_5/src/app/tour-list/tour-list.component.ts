import {Component, OnInit} from '@angular/core';
import {TourService} from "../service/tour.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Tour} from "../model/tour";
// @ts-ignore
import Swal from 'sweetalert2/dist/sweetalert2.js';
@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {
  ngOnInit(): void {
    this.getAll()
  }
  constructor(private tourService: TourService) {
  }
  tourCreateForm: FormGroup = new FormGroup({
    title: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  })

  tourUpdateForm: FormGroup = new FormGroup({
    id: new FormControl(),
    title: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  })

  tours: Tour[] = []
  quantity: number = 0;
  tour: Tour | undefined
  tourPaging: Tour[] = []
  k: number = 0

  onScroll(){
    for (let i = this.k; i < this.k + 12; i++) {
      if (this.tours[i] !== undefined) {
        this.tourPaging[i] = this.tours[i]
      } else {
        break
      }
    }
    console.log(this.tourPaging)
    this.k += 12
  }

  getAll() {
    this.tourService.getAll().subscribe(tours => {
      this.tourPaging = []
      this.tours = tours;
      this.quantity = tours.length
      this.onScroll()
    })
  }

  createTour(){
    const tour = this.tourCreateForm.value
    this.tourService.createTour(tour).subscribe(() => {
      this.tourCreateForm.reset();
      document.getElementById("btnCreate")?.click()
      this.confirmSuccess();
      this.getAll()
    })
  }

  updateTour(){
    const tour = this.tourUpdateForm.value
    this.tourService.updateTour(tour.id, tour).subscribe(() => {
      document.getElementById("btnCloseUpdate")?.click()
      this.confirmSuccess()
      this.getAll()
    })
  }

  getTour(id: any){
    this.tourService.findById(id).subscribe(tour => {
      this.tourUpdateForm.patchValue(tour)
    })
  }

  getDeleteTour(id: any){
    this.tourService.findById(id).subscribe(tour => {
      this.tour = tour
    })
  }

  deleteTour(id: any){
    this.tourService.deleteTour(id).subscribe(() => {
      document.getElementById("btnCloseDelete")?.click()
      this.confirmSuccess()
      this.getAll()
    })
  }

  confirmSuccess() {
    Swal.fire(
      'Successfully!',
      'You clicked the button!',
      'success'
    )
  }
}
