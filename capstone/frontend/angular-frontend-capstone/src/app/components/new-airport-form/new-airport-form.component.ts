import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { take } from 'rxjs';
import { Airport, Country } from 'src/Objects';
import { AirportService } from 'src/app/services/airport.service';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-new-airport-form',
  templateUrl: './new-airport-form.component.html',
  styleUrls: ['./new-airport-form.component.scss']
})
export class NewAirportFormComponent implements OnInit {
  submitSuccessAirport: string|null = null;
  submitted = false;
  countryList!: Country[];
  form!: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private airportService: AirportService, private countryService: CountryService) { }

  ngOnInit() {
    this.countryService.retrieveAllCountries().subscribe((data) => this.countryList = data);

    this.form = this.formBuilder.group({
      airportName: ['', [Validators.required]],
      countryCode: ['', [Validators.required]]
    })
  }

  onSubmit() {
    if (this.form.invalid) {
      console.log("Invalid details, form data not submitted!");
      console.log(JSON.stringify(this.form.value));
      console.log(JSON.stringify(this.form.errors));
      return;
    }
    let airport: Airport = this.form.value;
    this.airportService.createAirport(airport).pipe(take(1))
      .subscribe(
        {
          next: (v) => {
            this.submitSuccessAirport = v.airportCode;

          },
          error: (e) => this.submitSuccessAirport = null,
          complete: () => console.info('complete')
        }
      );
    // this.airportService.createAirport(airport).subscribe(
    //   {
    //     next: (v) => console.log(v),
    //     error: (e) => console.error(e),
    //     complete: () => console.info('complete')
    //   }
    // );
  }
}
