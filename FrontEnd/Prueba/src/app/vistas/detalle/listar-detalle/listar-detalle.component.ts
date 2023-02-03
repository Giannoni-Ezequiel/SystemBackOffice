import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DetalleService } from 'src/app/service/detalle.service';
import { Pedido_Detalle } from 'src/app/models/pedido_detalle';

@Component({
  selector: 'app-listar-detalle',
  templateUrl: './listar-detalle.component.html',
  styleUrls: ['./listar-detalle.component.css']
})
export class ListarDetalleComponent implements OnInit{

  detalle!:Pedido_Detalle[];

  constructor(
    private service:DetalleService,
    private router:Router)
    {}

  ngOnInit(): void{
    this.service.getDetalle().subscribe(data=>{
      this.detalle=data;
    })
  }

  Editar(detalle:Pedido_Detalle):void{
    localStorage.setItem("id",detalle.id!.toString());
    this.router.navigate(["editar-detalle"]);
  }

  Delete(detalle:Pedido_Detalle){
    this.service.deleteDetalle(detalle).subscribe(data=>{
      this.detalle=this.detalle?.filter(d=>d!==detalle);
      alert("PedidoDetalle eliminado!!!")
    })
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear-detalle"])
  }
}
