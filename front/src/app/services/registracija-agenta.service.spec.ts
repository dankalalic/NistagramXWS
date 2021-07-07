import { TestBed } from '@angular/core/testing';

import { RegistracijaAgentaService } from './registracija-agenta.service';

describe('RegistracijaAgentaService', () => {
  let service: RegistracijaAgentaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistracijaAgentaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
