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

import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { ErrComponent } from './err/err.component';
import { MedicalRecordComponent } from './medical-record/medical-record.component';
import { MedicalRecordEditComponent } from './medical-record/medical-record-edit/medical-record-edit.component';
import { MedicalRecordDeleteComponent } from './medical-record/medical-record-delete/medical-record-delete.component';
import { TextComponent } from './text/text.component';
import { TextTemiComponent } from './text-temi/text-temi.component';



const routes: Routes = [
  {path: '', component: MedicalRecordComponent},
  {path: 'medicalRecord', component: MedicalRecordComponent},
  {path: 'medicalRecord-edit/:id', component: MedicalRecordEditComponent},
  {path: '**', component: ErrComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ErrComponent,
    MedicalRecordComponent,
    MedicalRecordEditComponent,
    MedicalRecordDeleteComponent,
    TextComponent,
    TextTemiComponent,

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
