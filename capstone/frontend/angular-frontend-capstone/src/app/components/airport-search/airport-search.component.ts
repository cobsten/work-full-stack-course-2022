import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Airport, AirportSearch, Country } from 'src/Objects';

@Component({
  selector: 'app-airport-search',
  templateUrl: './airport-search.component.html',
  styleUrls: ['./airport-search.component.scss']
})
export class AirportSearchComponent {

  airport!: Airport;
  @Input()
  countryList !: Country[];

  @Output()
  searchItemEvent = new EventEmitter<AirportSearch>();

  submitSearch(airportName:string, countryCode:string){
    let item: AirportSearch = {airportCode:null,airportName:(airportName?airportName.toUpperCase():null),countryCode:(countryCode?countryCode:null)};
    console.log(JSON.stringify(item));
    this.searchItemEvent.emit(item);
  }
}
