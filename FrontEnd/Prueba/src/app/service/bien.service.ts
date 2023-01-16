import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
//import { Observable } from 'rxjs';
import { Bien } from '../models/bien';
import { environment } from '../enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class BienService {
  //private Url = environment.apiBaseUrl + 'bien';

  constructor(private http:HttpClient) { }
  Url = 'http://localhost:8080/clientes';

  getBien(){
    return this.http.get<Bien[]>(this.Url);
  }
  crearBien(bien:Bien){
    return this.http.post<Bien>(this.Url,bien);
  }
  getBienId(id:any){
    return this.http.get<Bien>(this.Url+"/"+id);
  }
  updateBien(bien:Bien){
    return this.http.put<Bien>(this.Url+"/"+bien.id,bien);
  }
  deleteBien(bien:Bien){
    return this.http.delete<Bien>(this.Url+"/"+bien.id);
  }
   /*public lista(): Observable<Bien[]>{
    return this.httpClient.get<Bien[]>(this.URL + 'lista');
  }
  public save(bien: Bien): Observable<any>{
      return this.httpClient.post<any>(this.URL + 'create', bien);
    }
 public detail(id: number): Observable<Bien>{
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
