import { Component, OnInit } from '@angular/core';
import { DataServiceService} from '../data-service.service';
import {FormGroup, FormBuilder } from '@angular/forms';
import { foodModel } from './admin-dashboard.model';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  posts:any;
  showAdd !:boolean;
  foodModelObj : foodModel= new foodModel;
  formValue !:FormGroup;
  constructor(private formBuilder:FormBuilder, private DataServiceService:DataServiceService) { }

  ngOnInit(): void {
    this.getAllFood();
    this.formValue=this.formBuilder.group({
      itemId:[''],
      itemName:[''],
      category:[''],
      price:[''],  
      itemVendor:['']

    })
  }
  getAllFood(){
    this.DataServiceService.getPost().subscribe(response => this.posts=response);
  }

  clickAddFood(){
    this.formValue.reset();
    this.showAdd=true;
    
  }
  postFoodDetail(){
    this.foodModelObj.itemId=this.formValue.value.itemId;
    this.foodModelObj.itemName=this.formValue.value.itemName;
    this.foodModelObj.category=this.formValue.value.category;
    this.foodModelObj.price=this.formValue.value.price;
    this.foodModelObj.itemVendor=this.formValue.value.itemVendor;
  
    this.DataServiceService.postFood(this.foodModelObj)
    .subscribe(res=>{
      console.log(res);
      alert("Food item added successfully");
      let ref=document.getElementById('cancel');
      ref?.click();
      this.formValue.reset();
      this.getAllFood();
      
    }, err=>{
      alert("Something went wrong");
    })
  }
  
  deleteFoodItem(post:any){
      this.DataServiceService.deleteFood(post.itemId)
      .subscribe(res => {
        alert("Food item deleted");
        this.getAllFood();
      })
  }

}
