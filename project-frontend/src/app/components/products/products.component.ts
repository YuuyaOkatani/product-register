import { Component, OnInit,} from '@angular/core';
import { Product } from '../../Product';
import { Category } from '../../Category';
import { CategoryService } from '../../services/category.service';
import { ProductService } from '../../services/product.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  products: Product[] =[]; 

  product: Product = {} as Product; 

  categories: Category[] = [];

  showForm: Boolean = false; 
  isEditing: boolean = false;

  constructor(
    private categoryService: CategoryService,
    private productService: ProductService,
    private modalService: NgbModal,
  
  ) { }


  ngOnInit(): void {
    this.loadCategories()
    this.loadProducts(); // Carregando os produtos quando a página é carregada
    
    
      
  }

  loadCategories(){
    this.categoryService.getCategories().subscribe({
      next: (categories) => {
        this.categories = categories;
      }
    })
  }

  loadProducts(){
    this.productService.getProducts().subscribe({
      next: (products) => {
        this.products = products;
      }
    })
  }

  saveProduct(save: boolean){
    if(save){
      if(this.isEditing){
        this.productService.update(this.product).subscribe()

      }
      else{
        this.productService.save(this.product).subscribe({
          next: data =>{
            this.products.push(data);
            
          }
        })
      }
    }
    this.product = {} as Product; // Resetando o formulário
    this.showForm = false; 
    
  }

  create(){
    this.showForm = true;
  }

  edit(product: Product){
    this.showForm = true; 
    this.product = product; 
    this.isEditing = true; 



  }

  deleteProduct(modal: any, product: Product){
    this.product = product; 
    this.modalService.open(modal).result.then(
      (confirm) => {
        if(confirm){
          this.productService.delete(product).subscribe({
            next: () => {
              this.products = this.products.filter(p => p.id!== product.id)
            }
          })
          this.showForm = false;
          this.product = {} as Product;
        }
      }
    )
    

   

  }


  



  





}
