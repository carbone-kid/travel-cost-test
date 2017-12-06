import {Component, Input, OnInit} from '@angular/core';
import {FareResponse} from '../../model/fare-response';

@Component({
  selector: 'app-fare',
  templateUrl: './fare.component.html',
  styleUrls: ['./fare.component.css']
})
export class FareComponent implements OnInit {
  @Input() fareResponse: FareResponse;

  constructor() { }

  ngOnInit() {
  }

}
