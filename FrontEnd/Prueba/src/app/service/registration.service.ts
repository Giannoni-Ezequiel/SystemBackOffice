import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../enviroments/enviroment';
import { LoginUsuario } from '../models/usuario';
import { Observable } from 'rxjs';
import { ResponseI } from '../models/response.interface';

@Injectable
({
  providedIn: 'root'
})
export class RegistrationService {

  private url = environment.apiBaseUrl;

  constructor(private httpClient: HttpClient) { }

  public login(loginUsuario: LoginUsuario): Observable<ResponseI>
  {
    return this.httpClient.post<ResponseI>(this.url + 'usuario/login/', loginUsuario);
  }


}
