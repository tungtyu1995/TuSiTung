import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router, ActivatedRoute } from '@angular/router';
import {MedicalRecordService} from '../../server/medical-record.service';



@Component({
  selector: 'app-medical-record-edit',
  templateUrl: './medical-record-edit.component.html',
  styleUrls: ['./medical-record-edit.component.css']
})
export class MedicalRecordEditComponent implements OnInit {

  public formEdit: FormGroup;
  public medicalRecordOfId;


  constructor(
    public formBuilder: FormBuilder,
    public medicalRecordServer: MedicalRecordService,
    public router: Router,
    public activatedRouter: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      id: [''],
      idRecord: [''],
      patientId: [''],
      patientName: ['', Validators.required],
      startIn: ['', [Validators.required]],
      startOut: ['', [Validators.required]],
      reason: ['', [Validators.required]],
      treatmentMethods: ['', [Validators.required]],
      doctorName: ['', [Validators.required]]
    });

    this.activatedRouter.params.subscribe(data => {
      this.medicalRecordOfId = data.id;
      // tslint:disable-next-line:no-shadowed-variable
      this.medicalRecordServer.getByID(this.medicalRecordOfId).subscribe(data => {
        console.log(data);
        this.formEdit.patchValue(data);
      });
    });

  }

  edit() {
    this.medicalRecordServer.edit(this.formEdit.value, this.medicalRecordOfId).subscribe(data => {
      this.router.navigate(['medicalRecord'], {queryParams: {edit_msg: 'Sửa Thành Công !!!', si: true}});
      // this.router.navigateByUrl('customer')
    });
  }

}
