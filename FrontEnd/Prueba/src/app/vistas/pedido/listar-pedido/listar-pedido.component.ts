import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PedidoService } from 'src/app/service/pedido.service';
import { Pedido } from 'src/app/models/pedido';

@Component({
  selector: 'app-listar-pedido',
  templateUrl: './listar-pedido.component.html',
  styleUrls: ['./listar-pedido.component.css']
})
export class ListarPedidoComponent implements OnInit{

  pedido:Pedido[] = [];
  constructor(private service:PedidoService, private router:Router){}

  ngOnInit(){
    this.service.getPedido().subscribe(data=>{
      this.pedido=data;
    })
  }

  Editar(pedido:Pedido):void{
    localStorage.setItem("id",pedido.id!.toString());
    this.router.navigate(["editar-pedido"]);
  }

  Delete(pedido:Pedido){
    this.service.deletePedido(pedido).subscribe(data=>{
      this.pedido=this.pedido?.filter(p=>p!==pedido);
      alert("Pedido eliminado!!!")
    })
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear-pedido"])
  }
}
