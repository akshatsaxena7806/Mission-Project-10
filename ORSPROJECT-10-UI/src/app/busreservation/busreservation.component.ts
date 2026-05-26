
import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-faculty',
  templateUrl: './busreservation.component.html',
  
})
export class BusReservationComponent extends BaseCtl{

  constructor(public locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.BUSRESERVATION, locator, route);
  }

}
