import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../enviroments/enviroment';
import { Impuesto } from '../models/impuesto';

@Injectable({
  providedIn: 'root'
})
export class ImpuestoService {

  constructor(private http:HttpClient) { }

  //private Url = environment.apiBaseUrl;
  Url = 'http://localhost:8080/impuestos';

  getImpuesto(){
    return this.http.get<Impuesto[]>(this.Url);
  }
  crearImpuesto(impuesto:Impuesto){
    return this.http.post<Impuesto>(this.Url,impuesto);
  }
  getImpuestoId(id:any){
    return this.http.get<Impuesto>(this.Url+"/"+id);
  }
  updateImpuesto(impuesto:Impuesto){
    return this.http.put<Impuesto>(this.Url+"/"+impuesto.id,impuesto);
  }
  deleteImpuesto(impuesto:Impuesto){
    return this.http.delete<Impuesto>(this.Url+"/"+impuesto.id);
  }
}
