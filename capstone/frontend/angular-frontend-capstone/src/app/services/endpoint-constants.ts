export class EndpointConstants{
    static serverUrl : string = 'http://localhost:8080';
    static createUserApiFragment = '/api/users';
    static queryEmailExistsApiFragment = '/api/users/emails/exist';
    static retrieveAirportsApiFragment = '/api/airports';
    static countryBaseApiUrl = `${EndpointConstants.serverUrl}/api/countries`;
}