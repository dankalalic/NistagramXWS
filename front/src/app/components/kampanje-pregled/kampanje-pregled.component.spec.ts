import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KampanjePregledComponent } from './kampanje-pregled.component';

describe('KampanjePregledComponent', () => {
  let component: KampanjePregledComponent;
  let fixture: ComponentFixture<KampanjePregledComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KampanjePregledComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KampanjePregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
