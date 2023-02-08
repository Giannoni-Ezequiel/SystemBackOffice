import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PedidoService } from 'src/app/service/pedido.service';
import { Pedido } from 'src/app/models/pedido';
import { DetalleService } from 'src/app/service/detalle.service';
import { Pedido_Detalle } from 'src/app/models/pedido_detalle';
import { Cliente } from 'src/app/models/cliente';
import { MatTableDataSource } from '@angular/material/table';
import { BienService } from 'src/app/service/bien.service';
import { Bien } from 'src/app/models/bien';
import { ClienteService } from 'src/app/service/cliente.service';

@Component({
  selector: 'app-listar-pedido',
  templateUrl: './listar-pedido.component.html',
  styleUrls: ['./listar-pedido.component.css']
})
export class ListarPedidoComponent implements OnInit{
  pedido:Pedido[] = [];
  detalle:Pedido_Detalle[] = [];
  columnas: string[] = ['nombre', 'apellido', 'empresa']
  cliente: Cliente[] = [
    new Cliente('','',0,'','','','','', new Date)
  ];
  bien!: Bien;

  constructor(
    private service1:PedidoService,
    private service2:DetalleService,
    private service3:BienService,
    private service4:ClienteService,
    private router:Router,
    )
    {
    }
  dataSource: any;
  ngOnInit(){

    this.service1.getPedido().subscribe(data=>{
      this.pedido=data;
      this.service2.getDetalle().subscribe(data=>{
        this.detalle=data;
      })
    })
    this.dataSource = new MatTableDataSource(this.cliente);
  }
  CargarDetalle(bien:Bien){
    this.service3.crearBien(bien).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["crear-bien"]);
    })
  }

  /*BuscarCliente(id:any){
    this.service4.getClienteId(id).subscribe(data=>{
      this.cliente=data;
    })
  }*/

  filtrar(event: Event) {
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLowerCase();
  }

  EditarDetalle(detalle:Pedido_Detalle):void{
    localStorage.setItem("id",detalle.id!.toString());
    this.router.navigate(["editar-detalle"]);
  }

  DeleteDetalle(detalle:Pedido_Detalle){
    if(window.confirm('¿Estas seguro de querer borrar?')){
    this.service2.deleteDetalle(detalle).subscribe(data=>{
      this.detalle=this.detalle?.filter(d=>d!==detalle);
      alert("PedidoDetalle eliminado!!!")
    })
  }
  }

  CrearDetalle(detalle:Pedido_Detalle){
    this.service2.crearDetalle(detalle).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-detalle"]);
    })
  }

  Editar(pedido:Pedido):void{
    localStorage.setItem("id",pedido.id!.toString());
    this.router.navigate(["editar-pedido"]);
  }

  Delete(pedido:Pedido){
    this.service1.deletePedido(pedido).subscribe(data=>{
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
