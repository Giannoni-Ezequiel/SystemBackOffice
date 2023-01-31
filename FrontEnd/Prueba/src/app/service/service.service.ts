import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url="http://localhost:8080/demo/cliente";

  getClientes(){
    return this.http.get<Cliente[]>(this.Url);
  }
  crearCliente(cliente:Cliente){
    return this.http.post<Cliente>(this.Url,cliente);
  }
  getClienteId(id:number){
    return this.http.get<Cliente>(this.Url+"/"+id);
  }
  updateCliente(cliente:Cliente){
    return this.http.put<Cliente>(this.Url+"/"+cliente.id,cliente);
  }
  deleteCliente(cliente:Cliente){
    return this.http.delete<Cliente>(this.Url+"/"+cliente.id);
  }
}
