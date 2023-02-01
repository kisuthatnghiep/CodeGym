import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductAngularComponent } from './product-angular.component';

describe('ProductAngularComponent', () => {
  let component: ProductAngularComponent;
  let fixture: ComponentFixture<ProductAngularComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductAngularComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductAngularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
