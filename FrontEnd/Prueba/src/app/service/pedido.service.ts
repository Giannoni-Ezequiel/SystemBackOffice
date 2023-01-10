import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
//import { Observable } from 'rxjs';
import { Pedido } from '../models/pedido';
import { environment } from '../enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  private Url = environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  getPedido(){
    return this.http.get<Pedido[]>(this.Url);
  }
  crearPedido(pedido:Pedido){
    return this.http.post<Pedido>(this.Url+"pedido",pedido);
  }
  getPedidoId(id:any){
    return this.http.get<Pedido>(this.Url+"/"+id);
  }
  updatePedido(pedido:Pedido){
    return this.http.put<Pedido>(this.Url+"/"+pedido.id,pedido);
  }
  deletePedido(pedido:Pedido){
    return this.http.delete<Pedido>(this.Url+"/"+pedido.id);
  }
  /*public lista(): Observable<Pedido[]>{
    return this.httpClient.get<Pedido[]>(this.URL + 'lista');
  }
  public save(pedido: Pedido): Observable<any>{
      return this.httpClient.post<any>(this.URL + 'create', pedido);
    }*/

  }
