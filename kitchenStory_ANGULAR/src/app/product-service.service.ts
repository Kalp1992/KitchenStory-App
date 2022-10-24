import { Injectable } from '@angular/core';
import { BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  public cartItemList : any = [];
  public itemList = new BehaviorSubject<any>([]);
  public search= new BehaviorSubject<string>(" ");
  constructor() { }
  getFoodProduct(){
    return this.itemList.asObservable();
  }
  setFoodProduct(item:any){
    this.cartItemList.push(...item);
    this.itemList.next(item);
 
  }
}
