import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  public formCreateCustomer: FormGroup;

  constructor(
    public formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.formCreateCustomer = this.formBuilder.group({
      id : [''],
      name : [''],
      birthday : [''],
      idCard : [''],
      phoneNumber : [''],
      email : [''],
      address : [''],
      idCustomerType : ['']
    })
  }


  createCustomer() {
    console.log(this.formCreateCustomer.value);

  }
}
