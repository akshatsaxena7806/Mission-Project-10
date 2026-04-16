import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient: HttpClient , private router : Router) {
   }

   post(endpoint: any , bean : any , callback:any){
    return this.httpClient.post(endpoint, bean, ).subscribe((data)=>{
      callback(data)
    },(error)=>{

    });
   }


   get(endpoint : any , callback : any){
    return this.httpClient.get(endpoint , ). subscribe((data)=>{
      callback(data)
    },(error)=>{
      
    });
    }
private handleError(error: any, callback: any) {
    if (error.status === 503) {
      callback({
        success: false,
        result: {
          message: error.error?.result?.message
        }
      })
    }
  }
    

}








