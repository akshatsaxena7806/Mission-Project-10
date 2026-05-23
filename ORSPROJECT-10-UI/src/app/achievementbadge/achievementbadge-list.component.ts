import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-arobject-list',
  templateUrl: './achievementbadge-list.component.html'
})
export class AchievementbadgeListComponent extends BaseListCtl {

  constructor(locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.ACHIVEMENTBADGE, locator, route);
  }

}