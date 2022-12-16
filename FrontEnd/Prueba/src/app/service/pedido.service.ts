import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from '../models/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  URL = '';

  constructor(private httpClient : HttpClient) { }

  public lista(): Observable<Pedido[]>{
    return this.httpClient.get<Pedido[]>(this.URL + 'lista');
  }
  public save(pedido: Pedido): Observable<any>{
      return this.httpClient.post<any>(this.URL + 'create', pedido);
    }

  }
