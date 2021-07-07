import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeprikladansadrzajComponent } from './neprikladansadrzaj.component';

describe('NeprikladansadrzajComponent', () => {
  let component: NeprikladansadrzajComponent;
  let fixture: ComponentFixture<NeprikladansadrzajComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeprikladansadrzajComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeprikladansadrzajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
