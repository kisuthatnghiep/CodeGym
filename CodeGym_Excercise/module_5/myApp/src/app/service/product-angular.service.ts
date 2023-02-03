import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Product} from "../model/product";
const API_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class ProductAngularService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Product[]>{
    return this.http.get<Product[]>(API_URL + `product`);
  }

  findById(id: number): Observable<Product>{
    return this.http.get<Product>(API_URL + `product/${id}`);
  }

  createProduct(product): Observable<any>{
    return this.http.post<any>(API_URL + `product`, product);
  }

  updateProduct(id: number, product): Observable<any>{
    return this.http.put<any>(API_URL + `product/${id}`, product);
  }

  deleteProduct(id: number): Observable<any>{
    return this.http.delete<any>(API_URL + `product/${id}`);
  }

  searchProduct(q: string): Observable<Product[]>{
    return this.http.get<Product[]>(API_URL + `product/search?q=` + q)
  }

  filterByCategory(id: any): Observable<Product[]>{
    return this.http.get<Product[]>(API_URL + `product/category/${id}`)
  }
}
