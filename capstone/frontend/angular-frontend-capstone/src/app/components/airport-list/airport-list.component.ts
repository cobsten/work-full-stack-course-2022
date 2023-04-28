import { Component, OnInit } from '@angular/core';
import { Airport } from 'src/Objects';
import { AirportService } from 'src/app/services/airport.service';

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.scss']
})
export class AirportListComponent implements OnInit{

  airportList!: Airport[];

  constructor(private airportService: AirportService){}

  ngOnInit(): void {
    this.airportService.retrieveAirports().subscribe(
      (data) =>{
        this.airportList = data;
      }
    );
  }

  updateItem(item: Airport){
    this.airportService.updateAirport(item).subscribe();
  }
  deleteItem(item: Airport){
    this.airportList = this.airportList.filter((arrayItem:Airport) => arrayItem.airportCode != item.airportCode)
  }

}
