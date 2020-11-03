import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../server/customer.service";
import {EmployeeService} from "../../server/employee.service";

@Component({
  selector: 'app-employee-delete-dialog',
  templateUrl: './employee-delete-dialog.component.html',
  styleUrls: ['./employee-delete-dialog.component.css']
})
export class EmployeeDeleteDialogComponent implements OnInit {

  public employeeName;
  public employeeOfId;

  constructor(
    public dialogRef: MatDialogRef<EmployeeDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public employeeServer: EmployeeService
  ) {
  }

  ngOnInit(): void {
    this.employeeName = this.data.data1.name;
    this.employeeOfId = this.data.data1.id
  }

  delete() {
    this.employeeServer.delete(this.employeeOfId).subscribe(data => {
      this.dialogRef.close()
    })
  }

}
