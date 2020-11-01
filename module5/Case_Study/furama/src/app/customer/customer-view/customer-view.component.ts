import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../model.customer";

@Component({
  selector: 'app-customer-view',
  templateUrl: './customer-view.component.html',
  styleUrls: ['./customer-view.component.css']
})
export class CustomerViewComponent implements OnInit {
  @Input('customer') customerView: Customer;
  constructor() { }

  ngOnInit(): void {
  }

}
