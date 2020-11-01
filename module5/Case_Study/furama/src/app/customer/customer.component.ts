import {Component, OnInit} from '@angular/core';
import {Customer} from "./model.customer";
import {Data} from "@angular/router";
import {inspect} from "util";


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {
  // @ts-ignore
  public customers: Customer[] = [
    {
      id: '123',
      name: 'abc',
      birthday: '12/12/2012',
      idCard: 12,
      phoneNumber: '8098977',
      email: 'ghfgh',
      address: 'jhf',
      idCustomerType: 12
    },
    {
      id: '129',
      name: 'xyz',
      birthday: '12/12/2019',
      idCard: 1234,
      phoneNumber: '80989774',
      email: 'ghfghghfg',
      address: 'jhf',
      idCustomerType: 12
    },

  ];

  private _customer: Customer;

  get customer(): Customer {
    return this._customer;
  }

  set customer(value: Customer) {
    this._customer = value;
  }

  onClick(item: Customer) {
    console.log(item);
    this._customer = item;
  }

  onGetCustomer(value: Customer) {
    this.customers.unshift(value);
  }
}
