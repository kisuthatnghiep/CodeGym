import { Component } from '@angular/core';
import {TourService} from "../service/tour.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Tour} from "../model/tour";

@Component({
  selector: 'app-tour-detail',
  templateUrl: './tour-detail.component.html',
  styleUrls: ['./tour-detail.component.css']
})
export class TourDetailComponent {
  tour: Tour | undefined
  id?: any
  constructor(private tourService: TourService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap | any) => {
      this.id = +paramMap.get('id');
      this.getTour(this.id).subscribe( tour =>{
        this.tour = tour
      })
    })
  }

  getTour(id: number) {
    return this.tourService.findById(id)
  }
}
