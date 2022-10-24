import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule} from '@angular/forms'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ItemsComponent } from './items/items.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminSignUpComponent } from './admin-sign-up/admin-sign-up.component';
import { CustomerSignUpComponent } from './customer-sign-up/customer-sign-up.component';
import { NonVegComponent } from './non-veg/non-veg.component';
import { SnacksComponent } from './snacks/snacks.component';
import { DairyComponent } from './dairy/dairy.component';
import { ChineeseComponent } from './chineese/chineese.component';
import { PureVegComponent } from './pure-veg/pure-veg.component';

import { CustomerServiceService} from './customer-service.service';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { FoodItemComponent } from './food-item/food-item.component';
import { FilterPipe } from './filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ItemsComponent,
    CustomerloginComponent,
    AdminloginComponent,
    AdminSignUpComponent,
    CustomerSignUpComponent,
    NonVegComponent,
    SnacksComponent,
    DairyComponent,
    ChineeseComponent,
    PureVegComponent,
    CustomerDashboardComponent,
    AdminDashboardComponent,
    FoodItemComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CustomerServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
