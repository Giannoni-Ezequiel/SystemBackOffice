import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/service/cliente.service';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrls: ['./crear.component.css']
})
export class CrearComponent implements OnInit {

  cliente:Cliente;

  constructor(private router:Router, private service:ClienteService){
    this.cliente = {
      nombre : '',
      dni : '',
      apellido : '',
      img : '',
      razonSocial : '',
      email : '',
      direccion : '',
      cuit : '',
      telefono : '',
      fechaDeInicio : new Date,
    }
  }

  ngOnInit() {
  }

  Crear(cliente:Cliente){
    this.service.crearCliente(cliente).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar"]);
    })
  }

  Volver(){
    this.router.navigate(["listar"])
  }

}
