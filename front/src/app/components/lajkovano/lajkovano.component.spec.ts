import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LajkovanoComponent } from './lajkovano.component';

describe('LajkovanoComponent', () => {
  let component: LajkovanoComponent;
  let fixture: ComponentFixture<LajkovanoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LajkovanoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LajkovanoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
