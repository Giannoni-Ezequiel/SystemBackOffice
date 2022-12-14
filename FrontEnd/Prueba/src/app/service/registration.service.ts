import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../enviroments/enviroment';
import { LoginUsuario } from '../models/usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private url = environment.apiBaseUrl;
  constructor(private httpClient: HttpClient) { }

  public login(loginUsuario: LoginUsuario): Observable<any>
  {
    return this.httpClient.post<any>(this.url + 'usuario/login', loginUsuario);
  }
}
