import { Injectable } from '@angular/core';
import { Product } from '../Product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[] = [];

  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/products"


  getProducts(): Observable <Product[]> {
    return this.http.get<Product[]>(this.url)
  }

  save(product: Product){
    return this.http.post<Product>(this.url, product);
  }

  update(product: Product){
    return this.http.put<Product>(`${this.url}/${product.id}`, product);
    // Retornar uma função editar do endpoint {http://localhost:8080/products/2, produto que será enviado}

  }
  delete(product: Product){
    return this.http.delete<Product>(`${this.url}/${product.id}`);
    // Retornar uma função editar do endpoint {http://localhost:8080/products/2, produto que será enviado}

  }







}
