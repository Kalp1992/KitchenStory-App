import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';



const routes: Routes = [{path:"home", component: HomeComponent}, {path:"items", component: ItemsComponent},
{path:"Customerlogin", component: CustomerloginComponent}, {path:"Adminlogin", component: AdminloginComponent}, 
{path:"Customersignup", component: CustomerSignUpComponent},{path:"Adminsignup", component: AdminSignUpComponent},
{path:"nonveg", component: NonVegComponent},{path:"snacks", component: SnacksComponent},
{path:"dairy", component: DairyComponent},{path:"chineese", component: ChineeseComponent},
{path:"pureveg", component: PureVegComponent}, {path:"customerdashboard", component: CustomerDashboardComponent},
{path:"admindashboard", component: AdminDashboardComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
