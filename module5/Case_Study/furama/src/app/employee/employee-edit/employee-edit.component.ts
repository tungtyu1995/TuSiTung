import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../../server/employee.service";

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  public formEdit: FormGroup;
  public employeeOfId;

  constructor(
    public formBuilder: FormBuilder,
    public employeeServer: EmployeeService,
    public router: Router,
    public activatedRouter: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('(NV)[\\d]{4,}')]],
      name: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^\\d{9,12}$')]],
      salary: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required]],
      position: ['', [Validators.required]]
    });

    this.activatedRouter.params.subscribe(data => {
      this.employeeOfId = data.id;
      this.employeeServer.getByID(this.employeeOfId).subscribe(data => {
        console.log(data);
        this.formEdit.patchValue(data)
      })
    })
  }

  edit() {
    this.employeeServer.edit(this.formEdit.value, this.employeeOfId).subscribe(data =>{
      this.router.navigateByUrl('employee')
    })
  }

}
