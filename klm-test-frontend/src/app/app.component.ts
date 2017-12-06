import {Component} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';
import {map} from 'rxjs/operators/map';
import {KlmTestService} from './services/klm-test.service';
import {FareResponse} from './model/fare-response';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  fareResponse: FareResponse = null;
  myControl: FormControl = new FormControl();
  options = [];
  origin: string;
  destination: string;

  constructor(private klmTestService: KlmTestService) {}

  ngOnInit() {
    this.klmTestService.getLocations().subscribe(r => this.options = r);
  }

  onSearchFares() {
    this.klmTestService.getFare(this.origin, this.destination).subscribe(r => this.fareResponse = r);
  }
}
