import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PedidoService } from 'src/app/service/pedido.service';
import { Pedido } from 'src/app/models/pedido';
import { Pedido_Detalle } from 'src/app/models/pedido_detalle';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-crear-pedido',
  templateUrl: './crear-pedido.component.html',
  styleUrls: ['./crear-pedido.component.css']
})
export class CrearPedidoComponent implements OnInit{

  pedido:Pedido;
  constructor(private router:Router, private service:PedidoService){
    this.pedido = {
      Ncomprobante: '',
      fecha: new Date(),
      totalPedido: 0,
      nomEmpEmisora: 'string',
      DescuentoPorcent: 0,
      DescuentoTotal: 0,
      pedido_detalle: [],
      cliente: new Cliente("","",1,"","","","","", new Date()),
    }
  }

  ngOnInit() {
  }

  Crear(pedido:Pedido){
    this.service.crearPedido(pedido).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-pedido"]);
    })
  }

  Volver(){
    this.router.navigate(["listar-pedido"])
  }
}
