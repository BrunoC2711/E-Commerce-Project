import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductModel } from '../models/form/product.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  baseUrl = environment.baseUrl;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'  })
  }
  constructor(private http: HttpClient) { }

  create(Product:ProductModel): Observable<ProductModel>{
    const url = `${this.baseUrl}`
    //return this.http.post<ProductModel>(url,Product)
    return this.http.post<ProductModel>(url,JSON.stringify(Product),this.httpOptions)
  }
  read(): Observable<ProductModel[]>{
    const url = `${this.baseUrl}`
    return this.http.get<ProductModel[]>(url)
  }
  readById(id: number): Observable<ProductModel>{
    const url = `${this.baseUrl}` 
    return this.http.get<ProductModel>(url);
  }
  readByTitle(title: string): Observable<ProductModel>{
    const url = `${this.baseUrl}?titulo=${title}` 
    return this.http.get<ProductModel>(url);
  }
  update(Product: ProductModel): Observable<ProductModel> {
    const url = `${this.baseUrl}`
    return this.http.post<ProductModel>(url,JSON.stringify(Product),this.httpOptions)
    //return this.http.put<ProductModel>(url, Product)
  }
  delete(Product: ProductModel): Observable<ProductModel>{
    const url = `${this.baseUrl}`;
    return this.http.post<ProductModel>(url,Product);
  }
}
