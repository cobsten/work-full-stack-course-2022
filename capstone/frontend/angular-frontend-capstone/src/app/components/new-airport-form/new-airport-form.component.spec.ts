import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAirportFormComponent } from './new-airport-form.component';

describe('NewAirportFormComponent', () => {
  let component: NewAirportFormComponent;
  let fixture: ComponentFixture<NewAirportFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewAirportFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewAirportFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
