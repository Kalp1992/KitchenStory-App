import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PureVegComponent } from './pure-veg.component';

describe('PureVegComponent', () => {
  let component: PureVegComponent;
  let fixture: ComponentFixture<PureVegComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PureVegComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PureVegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
