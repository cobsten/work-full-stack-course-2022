import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Airport, Country } from 'src/Objects';
import { AirportService } from 'src/app/services/airport.service';

@Component({
  selector: 'app-airport-item',
  templateUrl: './airport-item.component.html',
  styleUrls: ['./airport-item.component.scss']
})
export class AirportItemComponent{


  @Input()
  airport!: Airport;
  @Input()
  countryList!: Country[];

  airportCode!: string;
  airportName!: string;
  countryCode!: string;

  toDelete: boolean = false;
  toUpdate: boolean = false;  

  @Output()
  updateItemEvent = new EventEmitter<Airport>();
  
  @Output()
  deleteItemEvent = new EventEmitter<Airport>();

  updateItem(inputName:string, country:string){
    let item: Airport = {airportCode:this.airport.airportCode,airportName:inputName.toUpperCase(),countryCode:country};
    console.log(JSON.stringify(item))
    this.updateItemEvent.emit(item);
  }

  deleteItem(){
     this.deleteItemEvent.emit(this.airport);
  }

}
