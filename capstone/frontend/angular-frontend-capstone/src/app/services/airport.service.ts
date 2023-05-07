import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Airport, AirportSearch } from 'src/Objects';
import { EndpointConstants } from './endpoint-constants';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  private airportApiUrl = EndpointConstants.serverUrl.concat(EndpointConstants.retrieveAirportsApiFragment);
  constructor(private client: HttpClient) { }

  retrieveAirports(): Observable<Airport[]> {
    return this.client.get<Airport[]>(this.airportApiUrl).pipe(
      map((data) => {
        return data.map((item: Airport) => {
          return {
            airportCode: item.airportCode,
            airportName: item.airportName,
            countryCode: item.countryCode
          } as Airport;
        }
        )
      })
    )
  }

  createAirport(airport: Airport){
    return this.client.post<Airport>(this.airportApiUrl,this.toUpperCaseName(airport)).pipe(
      (data) =>{
        return data;
      }
    );
  }

  updateAirport(airport: Airport){
    return this.client.patch(this.airportApiUrl,this.toUpperCaseName(airport));
  }

  deleteAirport(airport: Airport){
    return this.client.delete<void>(this.airportApiUrl.concat("/",airport.airportCode));
  }

  searchAirport(airportSearch: AirportSearch):Observable<Airport[]>{
    return this.client.post<Airport[]>(this.airportApiUrl.concat("/search"),airportSearch);
  }

  private toUpperCaseName(input: Airport):Airport{
    input.airportName = input.airportName.toUpperCase();
    return input;
  }
}
