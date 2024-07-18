import { Injectable, OnInit } from '@angular/core';
import { Category } from '../Category';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService{

 

  constructor(private http: HttpClient) { }
  
  url = 'http://localhost:8080/categories'

  getCategories():Observable <Category[]> {
    return this.http.get<Category[]>(this.url); 

  }
}
