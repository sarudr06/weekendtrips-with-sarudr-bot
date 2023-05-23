import { Register, Login, Reset } from './login.model';
import { Packages } from './packages.model';
import { Place } from './place.model';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from "@angular/common/http";
import { City } from './city.model';
import { Observable } from 'rxjs';
import { Traveller } from './traveller.model';
import { Coupon } from './coupon.model';
import { Payment } from './payment.model';
import { Response } from './sarudrresponse.model';

const PORT=2020
const PORT1=8080
const PORTK=8500



const PROTOCOL="http"

const PROJECT="security"
const PROJECT1="weekendtrip"
const PROJECT2="traveller"
const PROJECT3="report"
const PROJECT4="payment"
const PROJECTK="openai"
@Injectable()
export class WeekendRestData{
  baseUrl: string;
  baseUrlLogin:string;
  baseUrlLogin2:string;
  baseUrlLogin3:string;
  baseUrlLogin4:string;
  baseUrlOpenai:string
  constructor(private http: HttpClient) {
    this.baseUrl = `${PROTOCOL}://${location.hostname}:${PORT1}/${PROJECT}/`;
    this.baseUrlLogin = `${PROTOCOL}://${location.hostname}:${PORT}/${PROJECT1}/`;
    this.baseUrlLogin2 = `${PROTOCOL}://${location.hostname}:${PORT}/${PROJECT2}/`;
    this.baseUrlLogin3 = `${PROTOCOL}://${location.hostname}:${PORT}/${PROJECT3}/`;
    this.baseUrlLogin4 = `${PROTOCOL}://${location.hostname}:${PORT}/${PROJECT4}/`;
    this.baseUrlOpenai = `${PROTOCOL}://${location.hostname}:${PORTK}/${PROJECTK}/`;

}

// * getting the all citys in the Getcitys (Ajax_call)

getCities(): Observable<City[]> {
  return this.http.get<City[]>(this.baseUrlLogin + "city/getallcities");
}

getTravellers(): Observable<Traveller[]> {
  return this.http.get<Traveller[]>(this.baseUrlLogin2 + "weekend/getalltravellers");
}
getPackages(): Observable<Packages[]> {
  return this.http.get<Packages[]>(`${this.baseUrlLogin}pack/getallpackages`);
}
getUsers(): Observable<Register[]> {
  return this.http.get<Register[]>(`${this.baseUrl}auth/getallusers`);
}
getuserarray(): Observable<String[]> {
  return this.http.get<String[]>(`${this.baseUrl}auth/getuserarray`);
}

// /tour/weekendtrip

//saving
saveCity(city:City): Observable<City> {
  return this.http.post<City>(this.baseUrlLogin + "city/savecity",city);
}
savePlace(place:Place,id:number):Observable<Place>{
  return this.http.post<Place>(`${this.baseUrlLogin}place/saveplacebypackid/${id}`,place);
}
savePack(pack:Packages,id:number):Observable<Packages>{
  console.log(pack)
  return this.http.post<Packages>(`${this.baseUrlLogin}pack/savepackagebycityid/${id}`,pack);
}

// savePassenger():Observable<>

resetPassword(reset:Reset):Observable<Register>{
  return this.http.post<Register>(`${this.baseUrl}auth/changepassword`,reset);
}
//status change
changeStatusOfUserAdmin(email:String):Observable<Register>{
  return this.http.delete<Register>(`${this.baseUrl}auth/changestatusofuserbyEmail/${email}`);
}
updateuser(register:Register,id:number):Observable<Register>{
  return this.http.put<Register>(`${this.baseUrl}auth/updateuser/${id}`,register);
}

// pagination():Observable<Traveller[]>{
  // let queryParams=new HttpParams();
// }


//deleting
deleteCity(id:number){
  // return this.http.delete(`${this.baseUrl}city/changestatusofcity/${id}`);
  return this.http.delete(`${this.baseUrl}weekend/changestatusofcity/${id}`);


}

deletePlace(id:number):Observable<City>{
  return this.http.delete<City>(`${this.baseUrlLogin}deletePlace/${id}`);
}
deletePack(id:number):Observable<City>{
  return this.http.delete<City>(`${this.baseUrlLogin}deletePack/${id}`);
}
deleteTraveller(id:number):Observable<City>{
  return this.http.delete<City>(`${this.baseUrlLogin}deleteTraveller/${id}`);
}

doPayment(payment:Payment):Observable<Payment>{
  console.log(payment)
  return this.http.post<Payment>(`${this.baseUrlLogin4}weekend/dopayment`,payment)
}



getPdf(id:number,amount:number):Observable<Blob>  {
 const headers= new HttpHeaders()
 headers.set('Access-Control-Allow-Origin', '*');
  return this.http.get(`${this.baseUrlLogin3}weekend/pdf/user/${id}/${amount}`,{ 'headers': headers,responseType:'blob'});
}

// paymentStatus(id:number,packprice:number):Observable<Traveller>{
//   return this.http.get<Traveller>(`${this.baseUrlLogin3}weekend/paymentstatus/${id}/${packprice}`);
// }
getfullPdf():Observable<Blob>{


  // this.http.get(`${this.baseUrlLogin4}weekend/pdf/user/${id}`
  
  const headers= new HttpHeaders()
    .set('Access-Control-Allow-Origin', '*');

  return this.http.get(`${this.baseUrlLogin3}weekend/pdf/admin`,{ 'headers': headers,responseType:'blob'});

}



//updating
 updateCity(id:number,city:City):Observable<City>{
   return this.http.put<City>(`${this.baseUrlLogin}city/updateCity/${id}`,city);
 }
 updatePlace(id:number,place:Place):Observable<City>{
  return this.http.put<City>(`${this.baseUrlLogin}place/updatePlace/${id}`,place);
}
updatePack(id:number,pack:Packages):Observable<City>{
  return this.http.put<City>(`${this.baseUrlLogin}pack/updatePack/${id}`,pack);
}



register(regForm:Register){
  console.log(regForm)
  return this.http.post(`${this.baseUrl}auth/register`,regForm);
}





saveTraveller(traveller:Traveller):Observable<Traveller>{
  
  console.log(traveller)

  return this.http.post<Traveller>(`${this.baseUrlLogin2}weekend/savetraveller`,traveller,{responseType:'json'})
}


login(loginForm:Login){
  console.log(loginForm)
  // console.log(
  //   localStorage.getItem('token')
  // );

  // let headers=new HttpHeaders()
  // .set("Authorization",`bearer ${localStorage.getItem('token')}`)
  // return this.http.post(`${this.baseUrlLogin}authenticate`,loginForm,{headers});
     return this.http.post(`${this.baseUrl}auth/authenticate`,loginForm);
}
// getcoupons//
getCoupons():Observable<Coupon[]>{
  return this.http.get<Coupon[]>(this.baseUrlLogin + "coupon/findallcoupon");
}

bookingHistory(travellerMail:string):Observable<Traveller[]>{
  return this.http.get<Traveller[]>(this.baseUrlLogin2+"weekend/getallbooked/aravind@gmail.com")
}


//open ai

getresponse(msg:string):Observable<Response>{
  console.log(msg)
  return this.http.post<Response>(`${this.baseUrlOpenai}chat`,{"question":msg})

}

}