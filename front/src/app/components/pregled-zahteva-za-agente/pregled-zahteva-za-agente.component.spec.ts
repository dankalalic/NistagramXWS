import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledZahtevaZaAgenteComponent } from './pregled-zahteva-za-agente.component';

describe('PregledZahtevaZaAgenteComponent', () => {
  let component: PregledZahtevaZaAgenteComponent;
  let fixture: ComponentFixture<PregledZahtevaZaAgenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledZahtevaZaAgenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PregledZahtevaZaAgenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
