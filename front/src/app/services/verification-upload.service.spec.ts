import { TestBed } from '@angular/core/testing';

import { VerificationUploadService } from './verification-upload.service';

describe('VerificationUploadService', () => {
  let service: VerificationUploadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VerificationUploadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
