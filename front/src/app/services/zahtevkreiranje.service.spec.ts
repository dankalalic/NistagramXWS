import { TestBed } from '@angular/core/testing';

import { ZahtevkreiranjeService } from './zahtevkreiranje.service';

describe('ZahtevkreiranjeService', () => {
  let service: ZahtevkreiranjeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZahtevkreiranjeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
