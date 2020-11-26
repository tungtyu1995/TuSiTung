import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// chuyen trang
import {Routes, RouterModule} from '@angular/router';
// search
import { Ng2SearchPipeModule } from 'ng2-search-filter';
// phan trang
import {NgxPaginationModule} from 'ngx-pagination';
// server
import {HttpClientModule} from '@angular/common/http';

import {MaterialModule} from './material.module';

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
import { CustomerDeleteComponent } from './customer/customer-delete/customer-delete.component';
import { EmployeeDeleteDialogComponent } from './employee/employee-delete-dialog/employee-delete-dialog.component';
import {MedicalRecordComponent} from "./medical-record/medical-record.component";
import {MedicalRecordEditComponent} from "./medical-record/medical-record-edit/medical-record-edit.component";
// @ts-ignore
import {ErrComponent} from "../../../err/err.component";

const routes: Routes = [
  {path: '', component: MedicalRecordComponent},
  {path: 'medicalRecord', component: MedicalRecordComponent},
  {path: 'medicalRecord-edit/:id', component: MedicalRecordEditComponent},
  {path: '**', component: ErrComponent},

  // {path: '**', component: PageNotFoundComponent},
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
    HomePageComponent,
    CustomerDeleteComponent,
    EmployeeDeleteDialogComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    Ng2SearchPipeModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    MaterialModule

  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }
