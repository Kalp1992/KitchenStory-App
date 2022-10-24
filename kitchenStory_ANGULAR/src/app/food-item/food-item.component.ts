import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {
  public posts:any;
  public filterCategory:any;
  searchKey:string='';
  constructor(private DataServiceService:DataServiceService, private productService:ProductServiceService) { }

  ngOnInit(): void {
    this.DataServiceService.getPost().subscribe(response => {this.posts=response;
     // this.filterCategory=response;
   
  })
    
  }

}
