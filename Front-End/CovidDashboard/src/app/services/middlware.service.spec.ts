import { TestBed } from '@angular/core/testing';

import { MiddlwareService } from './middlware.service';

describe('MiddlwareService', () => {
  let service: MiddlwareService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MiddlwareService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
