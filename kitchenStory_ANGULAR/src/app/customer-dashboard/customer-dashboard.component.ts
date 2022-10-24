import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {
  public totalItem:number=0;
  public searchTerm:string='';
  constructor(private productService:ProductServiceService, private dataservice:DataServiceService) { }

  ngOnInit(): void {
    this.productService.getFoodProduct()
    .subscribe(res=>{
       this.totalItem=res.length;

    })
  }
  search(event:any){
    this.searchTerm=(event.target as HTMLInputElement).value;
    console.log(this.searchTerm);
    this.productService.search.next(this.searchTerm);
  }

}
