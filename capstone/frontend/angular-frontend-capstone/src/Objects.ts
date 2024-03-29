export interface Admin {
    name: string,
    email: string,
    passphrase: string
}
export interface Airport {
    airportCode: string,
    airportName: string,
    countryCode: string
}
export interface AirportSearch {
    airportCode: string|null,
    airportName: string|null,
    countryCode: string|null
}
export interface Country {
    countryCode: string,
    countryName: string 
}