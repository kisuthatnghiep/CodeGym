import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Tour} from "../model/tour";
import {environment} from "../../environments/enviroment";
const API_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class TourService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Tour[]>{
    return this.http.get<Tour[]>(API_URL + `tours`);
  }

  findById(id: number): Observable<Tour>{
    return this.http.get<Tour>(API_URL + `tours/${id}`);
  }

  createTour(tour: Tour): Observable<any>{
    return this.http.post<any>(API_URL + `tours`, tour);
  }

  updateTour(id: number, tour: Tour): Observable<any>{
    return this.http.put<any>(API_URL + `tours/${id}`, tour);
  }

  deleteTour(id: number): Observable<any>{
    return this.http.delete<any>(API_URL + `tours/${id}`);
  }
}
