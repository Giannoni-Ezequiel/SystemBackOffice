import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';
import { environment } from '../enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private URL = environment.apiBaseUrl;

  constructor(private httpClient : HttpClient) { }

  public lista(): Observable<Cliente[]>{
    return this.httpClient.get<Cliente[]>(this.URL + 'lista');
  }
  public save(cliente: Cliente): Observable<any>{
      return this.httpClient.post<any>(this.URL + 'create', cliente);
    }
  }
