import {Component, OnInit} from '@angular/core';
import {Customer} from "./model.customer";
import {CustomerService} from '../server/customer.service'
import {CustomerDeleteComponent} from "./customer-delete/customer-delete.component";
import {MatDialog} from "@angular/material/dialog";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  term: any;
  p: any;


  public create_msg: string = '';
  public edit_msg: string = '';
  public delete_msg: string = '';

  public objList;

  constructor(
    public customerServer: CustomerService,
    public dialog: MatDialog,

    //dùng để báo ms
    private route: ActivatedRoute
  ) {
  }


  ngOnInit(): void {
    this.customerServer.getAll().subscribe(data => {
      this.objList = data;
      console.log(this.objList);
      this.sendMessage();
    })
  }

  sendMessage(){
    console.log(this.route.snapshot.queryParamMap.get('create_msg'));
    this.create_msg = this.route.snapshot.queryParamMap.get('create_msg');
    this.edit_msg = this.route.snapshot.queryParamMap.get('edit_msg');
    this.delete_msg = this.route.snapshot.queryParamMap.get('delete_msg');
  }


  openDialog(customerId): void {
    this.customerServer.getByID(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '400px',
        data: {data1: dataCustomer},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit()
      });
    });

  }
}
