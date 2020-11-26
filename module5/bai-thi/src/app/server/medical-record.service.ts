import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicalRecordService {

  public Api = 'http://localhost:3000/medicalRecord\n';

  constructor(
    public http: HttpClient
  ) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.Api);
  }

  getByID(medicalRecordId) {
    return this.http.get(this.Api + '/' + medicalRecordId);
  }

  delete(medicalRecordId): Observable<any> {
    return this.http.delete(this.Api + '/' + medicalRecordId);
  }

  edit(medicalRecord, medicalRecordId): Observable<any> {
    return this.http.put(this.Api + '/' + medicalRecordId, medicalRecord);
  }
}
