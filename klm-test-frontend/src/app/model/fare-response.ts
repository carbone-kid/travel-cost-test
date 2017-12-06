import {Fare} from './fare';
import {Locat} from './locat';

export class FareResponse {
  origin: Locat = new Locat();
  destination: Locat = new Locat();
  fare: Fare;
}
