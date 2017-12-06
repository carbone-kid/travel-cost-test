import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FareResponse} from '../model/fare-response';
import {environment} from '../../environments/environment';

@Injectable()
export class KlmTestService {

  constructor(private http: HttpClient) {}

  getLocations() {
    return this.http.get<string[]>( environment.backendUrl + 'api/locations');
  }

  getFare(origin: string, destination: string) {
    return this.http.get<FareResponse>(environment.backendUrl + 'api/fares/' + origin + '/' + destination);
  }
}
