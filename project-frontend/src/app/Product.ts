import { Category } from "./Category";

export interface Product{
    id: number;
    name: String; 
    desc: String; 
    price: number;
    category: Category;
    promotion: boolean; 
    novo: boolean;
}