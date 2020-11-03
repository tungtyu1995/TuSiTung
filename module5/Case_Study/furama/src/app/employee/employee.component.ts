import { Component, OnInit } from '@angular/core';


import {EmployeeService} from "../server/employee.service";
import {MatDialog} from "@angular/material/dialog";
import {EmployeeDeleteDialogComponent} from "./employee-delete-dialog/employee-delete-dialog.component";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  term: any;
  p: any;

  public objList;

  constructor(
    public employeeServer: EmployeeService,
    public dialog: MatDialog,
  ) {
  }


  ngOnInit(): void {
    this.employeeServer.getAll().subscribe(data => {
      this.objList = data;
      console.log(this.objList);
    })
  }


  openDialog(employeeId): void {
    this.employeeServer.getByID(employeeId).subscribe(dataEmployee => {
      const dialogRef = this.dialog.open(EmployeeDeleteDialogComponent, {
        width: '400px',
        data: {data1: dataEmployee},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit()
      });
    });

  }
}
