import { Component } from '@angular/core';
import { Airport } from 'src/Objects';

@Component({
  selector: 'app-airport-search',
  templateUrl: './airport-search.component.html',
  styleUrls: ['./airport-search.component.scss']
})
export class AirportSearchComponent {

  airport!: Airport;
  
}
