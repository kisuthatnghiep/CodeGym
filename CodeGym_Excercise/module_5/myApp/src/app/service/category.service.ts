import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
const API_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Category[]>{
    return this.http.get<Category[]>(API_URL + `category`);
  }

  saveCategory(category: any): Observable<String>{
    return this.http.post<String>(API_URL + `category`, category);
  }

  findById(id: number): Observable<Category>{
    return this.http.get<Category>(API_URL + `category/${id}`);
  }

  updateCategory(id: number, category: any): Observable<Category>{
    // @ts-ignore
    return this.http.put<Category>(API_URL + `category/${id}`, category);
  }

  deleteCategory(id: number): Observable<Category>{
    return this.http.delete<Category>(API_URL + `category/${id}`);
  }
}
