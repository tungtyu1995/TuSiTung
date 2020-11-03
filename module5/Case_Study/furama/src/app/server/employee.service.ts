import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  public Api: string = ' http://localhost:3000/employee\n';

  constructor(
    public http: HttpClient
  ) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.Api);
  }

  create(employee) {
    return this.http.post(this.Api, employee);
  }

  getByID(employeeId) {
    return this.http.get(this.Api + '/' + employeeId);
  }

  delete(employeeId): Observable<any> {
    return this.http.delete(this.Api + '/' + employeeId);
  }

  edit(employee, employeeId): Observable<any> {
    return this.http.put(this.Api + '/' + employeeId, employee);
  }
}
