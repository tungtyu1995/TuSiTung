import { Component, OnInit } from '@angular/core';

import {MatDialog} from '@angular/material/dialog';
import {ActivatedRoute} from '@angular/router';

import {MedicalRecordService} from '../server/medical-record.service';
import {MedicalRecordDeleteComponent} from './medical-record-delete/medical-record-delete.component';

@Component({
  selector: 'app-medical-record',
  templateUrl: './medical-record.component.html',
  styleUrls: ['./medical-record.component.css']
})
export class MedicalRecordComponent implements OnInit {

  term: any;
  p: any;


  // tslint:disable-next-line:variable-name
  public create_msg = '';
  // tslint:disable-next-line:variable-name
  public edit_msg = '';
  // tslint:disable-next-line:variable-name
  public delete_msg = '';

  public objList;

  constructor(
    public medicalRecordServer: MedicalRecordService,
    public dialog: MatDialog,

    // dùng để báo ms
    private route: ActivatedRoute
  ) {
  }


  ngOnInit(): void {
    this.medicalRecordServer.getAll().subscribe(data => {
      this.objList = data;
      console.log(this.objList);
      this.sendMessage();
    });
  }

  sendMessage(){
    console.log(this.route.snapshot.queryParamMap.get('create_msg'));
    this.create_msg = this.route.snapshot.queryParamMap.get('create_msg');
    this.edit_msg = this.route.snapshot.queryParamMap.get('edit_msg');
    this.delete_msg = this.route.snapshot.queryParamMap.get('delete_msg');
  }


  openDialog(medicalRecordId): void {
    this.medicalRecordServer.getByID(medicalRecordId).subscribe(dataMedicalRecord => {
      const dialogRef = this.dialog.open(MedicalRecordDeleteComponent, {
        width: '400px',
        data: {data1: dataMedicalRecord},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });

  }

}
