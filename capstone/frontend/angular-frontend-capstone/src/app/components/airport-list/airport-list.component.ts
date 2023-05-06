import { Component, OnInit } from '@angular/core';
import { Airport, Country } from 'src/Objects';
import { AirportService } from 'src/app/services/airport.service';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.scss']
})
export class AirportListComponent implements OnInit{

  airportList!: Airport[];
  countryList!: Country[];

  constructor(private airportService: AirportService, private countryService: CountryService){}

  ngOnInit(): void {
    this.airportService.retrieveAirports().subscribe(
      (data) =>{
        this.airportList = data;
      }
    );
    this.countryService.retrieveAllCountries().subscribe(
      (data) => {
        this.countryList = data;
      }
    );
  }

  updateItem(item: Airport){
    console.log("submit:" + JSON.stringify(item));
    this.airportService.updateAirport(item).subscribe();
  }
  deleteItem(item: Airport){
    this.airportService.deleteAirport(item).subscribe();
    this.airportList = this.airportList.filter((arrayItem:Airport) => arrayItem.airportCode != item.airportCode)
  }

}
