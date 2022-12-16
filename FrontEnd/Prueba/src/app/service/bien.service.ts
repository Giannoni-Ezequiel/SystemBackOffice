import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bien } from '../models/bien';

@Injectable({
  providedIn: 'root'
})
export class BienService {
  URL = '';

  constructor(private httpClient : HttpClient) { }

  public lista(): Observable<Bien[]>{
    return this.httpClient.get<Bien[]>(this.URL + 'lista');
  }
  public save(bien: Bien): Observable<any>{
      return this.httpClient.post<any>(this.URL + 'create', bien);
    }
  /*public detail(id: number): Observable<Bien>{
    return this.httpClient.get<Bien>(this.URL + detail/${id});
  }*/



  /*public update(id: number, bien: Bien): Observable<any>{
    return this.httpClient.put<any>(this.URL + update/${id}, bien);
  }*/

  /*public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + delete/${id});
  }*/

  /*public EsEspecial(): Observable<Bien[]>{
    return Bien;
  }*/
}
