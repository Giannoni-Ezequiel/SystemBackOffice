import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PedidoService } from 'src/app/service/pedido.service';
import { Pedido } from 'src/app/models/pedido';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-editar-pedido',
  templateUrl: './editar-pedido.component.html',
  styleUrls: ['./editar-pedido.component.css']
})
export class EditarPedidoComponent implements OnInit{

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

  ngOnInit(){
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getPedidoId(id).subscribe(data=>{
      this.pedido=data;
    })
  }

  Actualizar(pedido:Pedido){
    this.service.updatePedido(pedido).subscribe(data=>{
      this.pedido = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-pedido"])
    })
  }

  Volver(){
    this.router.navigate(["listar-pedido"])
  }
}
