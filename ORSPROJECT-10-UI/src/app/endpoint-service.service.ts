import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EndpointServiceService {

  constructor() { }

  public SERVER_URL = 'http://localhost:8081';
  public ROLE =this.SERVER_URL +'/Role';
  public USER =this.SERVER_URL +'/User';
  public COLLEGE =this.SERVER_URL +'/College';
  public COURSE =this.SERVER_URL +'/Course';
  public SUBJECT =this.SERVER_URL +'/Subject';
  public STUDENT =this.SERVER_URL +'/Student';
  public MARKSHEET =this.SERVER_URL +'/Marksheet';
  public TIMETABLE =this.SERVER_URL +'/TimeTable';
  public FACULTY =this.SERVER_URL +'/Faculty';
  public AROBJECT =this.SERVER_URL +'/ARObject';
  public LANGUAGE =this.SERVER_URL +'/Language';
  public DRONE =this.SERVER_URL +'/Drone';
  public LIVESTREAMING =this.SERVER_URL +'/LiveStreaming';
  public GENDER=this.SERVER_URL +'/Gender';
  public EMPLOYEE=this.SERVER_URL +'/Employee';
  public ACHIVEMENTBADGE =this.SERVER_URL +'/AchievementBadge';
  public WEATHERSYSTEM =this.SERVER_URL +'/WeatherSystem';
  public BUSRESERVATION =this.SERVER_URL +'/BusReservation';
   public ELECTRICITYBILL =this.SERVER_URL +'/ElectricityBill';

}
