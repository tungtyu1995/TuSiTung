import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {CustomerService} from '../../server/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  public formCreate: FormGroup;
  public customerTypeList;

  constructor(
    public formBuilder: FormBuilder,
    public customerServer: CustomerService,
    public router: Router
  ) {
  };

  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('(KH)[\\d]{4,}')]],
      name: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^\\d{9,12}$')]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required]],
      customerType: ['', [Validators.required]]
    });
    this.customerServer.getCustomerType()
      .subscribe(data => this.customerTypeList = data, error => this.customerTypeList = []);
  }


  create() {
    console.log(this.formCreate.value);
    this.customerServer.create(this.formCreate.value).subscribe(data => {
      this.router.navigate(['customer'], {queryParams: {create_msg: 'Thêm mới thành công!', si: true}});
      // this.router.navigateByUrl('customer')
    })
  }
}
