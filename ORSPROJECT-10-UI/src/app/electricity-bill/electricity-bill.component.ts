
import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-faculty',
  templateUrl: './electricity-bill.component.html',
  
})
export class ElectricityBillComponent extends BaseCtl{

  constructor(public locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.ELECTRICITYBILL, locator, route);
  }

}
