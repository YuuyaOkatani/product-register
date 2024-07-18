import { Component, EventEmitter, Input, OnChanges, Output } from '@angular/core';
import { Product } from '../../Product';
import { Category } from '../../Category';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnChanges {



  @Input()
  product: Product = {} as Product;

  @Input()
  categories: Category[] = [];

  @Output()
  saveEmitter = new EventEmitter();

  formGroupProduct: FormGroup;

  constructor(private formbuilder: FormBuilder) {
    this.formGroupProduct = this.formbuilder.group({
      id: { value: null, disabled: true },
      name: ['', [Validators.required, Validators.minLength(3)]],
      desc: ['', [Validators.required]],
      price: ['', [Validators.required]],
      category: ['', [Validators.required]],
      promotion: [false],
      novo: [false]
    })
  }
  ngOnChanges(): void {
    if (this.product.id) {
      this.formGroupProduct.setValue(this.product);
    }

  }




  save() {
    if (this.formGroupProduct.valid) {
      Object.assign(this.product, this.formGroupProduct.value)
      this.saveEmitter.emit(true);
    }

  }

  cancel() {
    this.saveEmitter.emit(false);

  }

  selectedCategory(category1: Category, category2: Category): boolean {
    return category1 && category2 ? category1.id == category2.id : false;

  }

  get pfgName() {
    return this.formGroupProduct.get("name")
  }
  get pfgDesc() {
    return this.formGroupProduct.get("desc")
  }
  get pfgCat() {
    return this.formGroupProduct.get("category")
  }
  get pfgPrice() {
    return this.formGroupProduct.get("price")
  }




}
