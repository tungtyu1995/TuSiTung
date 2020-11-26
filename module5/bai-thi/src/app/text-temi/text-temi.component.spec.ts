import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TextTemiComponent } from './text-temi.component';

describe('TextTemiComponent', () => {
  let component: TextTemiComponent;
  let fixture: ComponentFixture<TextTemiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TextTemiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TextTemiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
