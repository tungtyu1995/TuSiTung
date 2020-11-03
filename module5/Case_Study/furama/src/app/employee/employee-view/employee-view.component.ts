import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../server/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../../server/employee.service";

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.css']
})
export class EmployeeViewComponent implements OnInit {

  public formView: FormGroup;
  public employeeOfId;

  constructor(
    public formBuilder: FormBuilder,
    public employeeService: EmployeeService,
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
      salary: [''],
      phoneNumber: [''],
      email: [''],
      address: [''],
      position: ['']
    });
    this.activatedRouter.params.subscribe(data => {
      this.employeeOfId = data.id;
      this.employeeService.getByID(this.employeeOfId).subscribe(data => {
        console.log(data);
        this.formView.patchValue(data)
      })
    })
  }

}
