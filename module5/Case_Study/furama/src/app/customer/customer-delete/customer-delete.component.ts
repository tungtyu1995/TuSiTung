import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../server/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  public customerName;
  public customerOfId;

  constructor(
    public dialogRef: MatDialogRef<CustomerDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public customerServer: CustomerService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.customerName = this.data.data1.name;
    this.customerOfId = this.data.data1.id
  }

  delete() {
    this.customerServer.delete(this.customerOfId).subscribe(data => {
      this.router.navigate(['customer'], {queryParams: {delete_msg: 'Delete successfully!', si: true}});
      this.dialogRef.close()
    })
  }
}
