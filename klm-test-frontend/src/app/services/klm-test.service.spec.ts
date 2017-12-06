import { TestBed, inject } from '@angular/core/testing';

import { KlmTestService } from './klm-test.service';

describe('KlmTestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KlmTestService]
    });
  });

  it('should be created', inject([KlmTestService], (service: KlmTestService) => {
    expect(service).toBeTruthy();
  }));
});
