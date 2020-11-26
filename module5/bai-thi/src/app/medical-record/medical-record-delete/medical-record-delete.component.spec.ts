import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalRecordDeleteComponent } from './medical-record-delete.component';

describe('MedicalRecordDeleteComponent', () => {
  let component: MedicalRecordDeleteComponent;
  let fixture: ComponentFixture<MedicalRecordDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalRecordDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalRecordDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
