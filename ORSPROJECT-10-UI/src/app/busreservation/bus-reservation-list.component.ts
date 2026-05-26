import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-faculty-list',
  templateUrl: './bus-reservation-list.component.html'
})
export class BusReservationListComponent extends BaseListCtl {

  constructor(locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.BUSRESERVATION, locator, route);
  }

}