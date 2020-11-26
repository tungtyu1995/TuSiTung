import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../model.customer";
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {CustomerService} from '../../server/customer.service';
import {Router, ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-customer-view',
  templateUrl: './customer-view.component.html',
  styleUrls: ['./customer-view.component.css']
})
export class CustomerViewComponent implements OnInit {

  public formView: FormGroup;
  public customerOfId;
  public customerTypeList;

  constructor(
    public formBuilder: FormBuilder,
    public customerServer: CustomerService,
    public router: Router,
    public activatedRouter: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.formView = this.formBuilder.group({
      id: [''],
      name: [''],
      birthday: [''],
      idCard: [''],
      phoneNumber: [''],
      email: [''],
      address: [''],
      customerType: ['']
    });
    this.activatedRouter.params.subscribe(data => {
      this.customerOfId = data.id;
      this.customerServer.getByID(this.customerOfId).subscribe(data => {
        console.log(data);
        this.formView.patchValue(data)
      })
    });
    this.customerServer.getCustomerType()
      .subscribe(data => this.customerTypeList = data, error => this.customerTypeList = []);
  }
}
