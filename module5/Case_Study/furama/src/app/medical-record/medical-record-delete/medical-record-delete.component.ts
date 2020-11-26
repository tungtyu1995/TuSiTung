import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {MedicalRecordService} from '../../server/medical-record.service';

@Component({
  selector: 'app-medical-record-delete',
  templateUrl: './medical-record-delete.component.html',
  styleUrls: ['./medical-record-delete.component.css']
})
export class MedicalRecordDeleteComponent implements OnInit {

  public medicalRecordName;
  public medicalRecordOfId;

  constructor(
    public dialogRef: MatDialogRef<MedicalRecordDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public medicalRecordServer: MedicalRecordService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.medicalRecordName = this.data.data1.idRecord;
    this.medicalRecordOfId = this.data.data1.id;
  }

  delete() {
    this.medicalRecordServer.delete(this.medicalRecordOfId).subscribe(data => {
      this.router.navigate(['medicalRecord'], {queryParams: {delete_msg: 'Delete successfully!', si: true}});
      this.dialogRef.close();
    });
  }

}
