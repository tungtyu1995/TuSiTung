import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { CustomerViewComponent } from './customer/customer-view/customer-view.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeEditComponent } from './employee/employee-edit/employee-edit.component';
import { EmployeeViewComponent } from './employee/employee-view/employee-view.component';
import { HomePageComponent } from './home-page/home-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-view', component: CustomerViewComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    CustomerCreateComponent,
    CustomerEditComponent,
    CustomerViewComponent,
    EmployeeComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    EmployeeViewComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    Ng2SearchPipeModule,
    ReactiveFormsModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }
