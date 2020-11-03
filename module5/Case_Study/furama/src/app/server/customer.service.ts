import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public Api: string = 'http://localhost:3000/customer\n';
  public Api_CustomerType = 'http://localhost:3000/customerType\n';

  constructor(
    public http: HttpClient
  ) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.Api);
  }

  create(customer) {
    return this.http.post(this.Api, customer);
  }

  getByID(customerId) {
    return this.http.get(this.Api + '/' + customerId);
  }

  delete(customerId): Observable<any> {
    return this.http.delete(this.Api + '/' + customerId);
  }

  edit(customer, customerId): Observable<any> {
    return this.http.put(this.Api + '/' + customerId, customer);
  }

  getCustomerType(): Observable<any> {
    return this.http.get(this.Api_CustomerType);
  }
}
