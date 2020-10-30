import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FonSizeComponent } from './fon-size.component';

describe('FonSizeComponent', () => {
  let component: FonSizeComponent;
  let fixture: ComponentFixture<FonSizeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FonSizeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FonSizeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
