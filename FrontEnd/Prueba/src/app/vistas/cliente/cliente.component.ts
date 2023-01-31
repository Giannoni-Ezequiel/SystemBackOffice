import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent {

  constructor(private router:Router) { }

  //Peticiones del backend

  Listar(){
    this.router.navigate(["listar"])
  }
  Crear(){
    this.router.navigate(["crear"])
  }

}
