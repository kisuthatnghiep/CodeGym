import { TestBed } from '@angular/core/testing';

import { ProductAngularService } from './product-angular.service';

describe('ProductAngularService', () => {
  let service: ProductAngularService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductAngularService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
