import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointConstants } from './endpoint-constants';
import { Country } from 'src/Objects';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  private countryApiBaseUrl = EndpointConstants.countryBaseApiUrl;
  constructor(private client: HttpClient) { }
  
  retrieveAllCountries(): Observable<Country[]>{
    return this.client.get<Country[]>(this.countryApiBaseUrl);
  }
  
}
