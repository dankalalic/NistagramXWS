import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazproizvodaComponent } from './prikazproizvoda.component';

describe('PrikazproizvodaComponent', () => {
  let component: PrikazproizvodaComponent;
  let fixture: ComponentFixture<PrikazproizvodaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrikazproizvodaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazproizvodaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
