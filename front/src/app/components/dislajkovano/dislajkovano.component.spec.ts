import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DislajkovanoComponent } from './dislajkovano.component';

describe('DislajkovanoComponent', () => {
  let component: DislajkovanoComponent;
  let fixture: ComponentFixture<DislajkovanoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DislajkovanoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DislajkovanoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
