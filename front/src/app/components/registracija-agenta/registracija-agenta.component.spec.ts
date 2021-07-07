import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistracijaAgentaComponent } from './registracija-agenta.component';

describe('RegistracijaAgentaComponent', () => {
  let component: RegistracijaAgentaComponent;
  let fixture: ComponentFixture<RegistracijaAgentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistracijaAgentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistracijaAgentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
