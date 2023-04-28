import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Airport } from 'src/Objects';
import { AirportService } from 'src/app/services/airport.service';

@Component({
  selector: 'app-new-airport-form',
  templateUrl: './new-airport-form.component.html',
  styleUrls: ['./new-airport-form.component.scss']
})
export class NewAirportFormComponent implements OnInit {
  submitted = false;
  form!: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private airportService: AirportService) { }

  ngOnInit(){
    this.form = this.formBuilder.group({
      airportName: ['', [Validators.required]],
      countryCode: ['', [Validators.required]]
    })
  }
  
  onSubmit(){
    if(this.form.invalid){
      console.log("Invalid details, form data not submitted!");
      console.log(JSON.stringify(this.form.value));
      console.log(JSON.stringify(this.form.errors));
      return;
    }
    let airport: Airport = this.form.value;
    this.airportService.createAirport(airport).subscribe(
      {
        next: (v) => console.log(v),
        error: (e) => console.error(e),
        complete: () => console.info('complete')
      }
    );
  }
}
