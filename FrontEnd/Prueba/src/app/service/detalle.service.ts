import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pedido_Detalle } from '../models/pedido_detalle';
import { environment } from '../enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class DetalleService {

  //private Url = environment.apiBaseUrl;
  Url = 'http://localhost:8080/detalle';

  constructor(private http:HttpClient) { }

  getDetalle(){
    return this.http.get<Pedido_Detalle[]>(this.Url);
  }
  crearDetalle(detalle:Pedido_Detalle){
    return this.http.post<Pedido_Detalle>(this.Url,detalle);
  }
  getDetalleId(id:any){
    return this.http.get<Pedido_Detalle>(this.Url+"/"+id);
  }
  updateDetalle(detalle:Pedido_Detalle){
    return this.http.put<Pedido_Detalle>(this.Url+"/"+detalle.id,detalle);
  }
  deleteDetalle(detalle:Pedido_Detalle){
    return this.http.delete<Pedido_Detalle>(this.Url+"/"+detalle.id);
  }
  getSubTotal(detalle:Pedido_Detalle){
    return this.http.put<Pedido_Detalle>(this.Url+"/calcular"+detalle.id,detalle);
  }
}
