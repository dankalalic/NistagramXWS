import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazproizvodauserComponent } from './prikazproizvodauser.component';

describe('PrikazproizvodauserComponent', () => {
  let component: PrikazproizvodauserComponent;
  let fixture: ComponentFixture<PrikazproizvodauserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrikazproizvodauserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazproizvodauserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
