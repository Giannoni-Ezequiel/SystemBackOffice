import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUsuario } from '../models/usuario';
import { environment } from '../enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http:HttpClient) { }

  private Url = environment.apiBaseUrl;

  getUsuarios(){
    return this.http.get<LoginUsuario[]>(this.Url);
  }
  crearUsuarios(usuario:LoginUsuario){
    return this.http.post<LoginUsuario>(this.Url+"usuario",usuario);
  }
  getUsuariosId(id:any){
    return this.http.get<LoginUsuario>(this.Url+"/"+id);
  }
  updateUsuarios(usuario:LoginUsuario){
    return this.http.put<LoginUsuario>(this.Url+"/"+usuario.id,usuario);
  }
  deleteUsuarios(usuario:LoginUsuario){
    return this.http.delete<LoginUsuario>(this.Url+"/"+usuario.id);
  }
}
