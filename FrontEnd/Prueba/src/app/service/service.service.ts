import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../models/cliente';
import { environment } from '../enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  private Url = environment.apiBaseUrl;

  getClientes(){
    return this.http.get<Cliente[]>(this.Url);
  }
  crearCliente(cliente:Cliente){
    return this.http.post<Cliente>(this.Url,cliente);
  }
  getClienteId(id:any){
    return this.http.get<Cliente>(this.Url+"/"+id);
  }
  updateCliente(cliente:Cliente){
    return this.http.put<Cliente>(this.Url+"/"+cliente.id,cliente);
  }
  deleteCliente(cliente:Cliente){
    return this.http.delete<Cliente>(this.Url+"/"+cliente.id);
  }
}
