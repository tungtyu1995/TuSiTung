import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {CustomerService} from '../../server/customer.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  public formEdit: FormGroup;
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
    this.formEdit = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('(KH)[\\d]{4,}')]],
      name: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^\\d{9,12}$')]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required]],
      customerType: ['', [Validators.required]]
    });

    this.activatedRouter.params.subscribe(data => {
      this.customerOfId = data.id;
      this.customerServer.getByID(this.customerOfId).subscribe(data => {
        console.log(data);
        this.formEdit.patchValue(data)
      })
    });
    this.customerServer.getCustomerType()
      .subscribe(data => this.customerTypeList = data, error => this.customerTypeList = []);
  }

  edit() {
    this.customerServer.edit(this.formEdit.value, this.customerOfId).subscribe(data =>{
      this.router.navigate(['customer'], {queryParams: {edit_msg: 'Sửa Thành Công !!!', si: true}});
      // this.router.navigateByUrl('customer')
    })
  }
}
