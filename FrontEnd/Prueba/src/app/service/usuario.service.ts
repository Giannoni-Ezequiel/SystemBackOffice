import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUsuario } from '../models/loginusuario';
import { environment } from '../enviroments/enviroment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http:HttpClient) { }

  Url = 'http://localhost:8080/usuario';
  url1 = 'http://localhost:8080/usuario/login?username=Eze&password=123456';

  getUsuarios(): Observable<any> {
    return this.http.get(this.Url);//<LoginUsuario[]>
  }
  crearUsuarios(usuario:LoginUsuario){
    console.log(usuario)
    return this.http.post<LoginUsuario>(this.Url,usuario);
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

  getUserData(nombreUsuario: string, password: string): Observable<any>
  {
    //return this.http.get(this.url1);
    return this.http.get(this.Url+"/login?username="+nombreUsuario+"&password="+password);
  }
}
