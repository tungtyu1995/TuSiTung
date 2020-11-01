import {Data} from "@angular/router";

export class Customer {
  id: String;
  name: String;
  birthday: String;
  idCard: number;
  phoneNumber: String;
  email: String;
  address: String;
  idCustomerType: number;


  constructor(id: String, name: String, birthday: String, idCard: number, phoneNumber: String, email: String, address: String, idCustomerType: number) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.idCard = idCard;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
    this.idCustomerType = idCustomerType;
  }
}
