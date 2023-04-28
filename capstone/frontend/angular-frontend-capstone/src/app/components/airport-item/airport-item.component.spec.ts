import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AirportItemComponent } from './airport-item.component';

describe('AirportItemComponent', () => {
  let component: AirportItemComponent;
  let fixture: ComponentFixture<AirportItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AirportItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AirportItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
