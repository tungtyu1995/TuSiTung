import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {EmployeeService} from "../../server/employee.service";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  public formCreate: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    public employeeServer: EmployeeService,
    public router: Router
  ) {
  };


  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('(NV)[\\d]{4,}')]],
      name: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^\\d{9,12}$')]],
      salary: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required]],
      position: ['', [Validators.required]]
    })
  }


  create() {
    console.log(this.formCreate.value);
    this.employeeServer.create(this.formCreate.value).subscribe(data => {
      this.router.navigateByUrl('employee')
    })
  }
}
