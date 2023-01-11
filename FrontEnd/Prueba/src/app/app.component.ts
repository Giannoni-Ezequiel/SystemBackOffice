import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '';
  description = '';
  constructor(private http: HttpClient, private router:Router) { }

  //Peticiones del backend
  ngOnInit() {

    /*this.http.get('https://localhost:8080/nombre', {responseType: 'text'}).subscribe(
      (resp:any) => {
      this.title = resp;
      }),
      (error:any) => {console.log(error)}

    this.http.get('https://localhost:8080/descripcion',  {responseType: 'text'}).subscribe(
      (resp:any) => {
      this.description = resp;
      }),
      (error:any) => {console.log(error)}*/

    }
  Listar(){
    this.router.navigate(["listar"])
  }
  Crear(){
    this.router.navigate(["crear"])
  }
  }
