import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DetalleService } from 'src/app/service/detalle.service';
import { Pedido_Detalle } from 'src/app/models/pedido_detalle';
import { Bien } from 'src/app/models/bien';
import { Pedido_Impuesto } from 'src/app/models/pedido_impuesto';

@Component({
  selector: 'app-editar-detalle',
  templateUrl: './editar-detalle.component.html',
  styleUrls: ['./editar-detalle.component.css']
})
export class EditarDetalleComponent implements OnInit{

  detalle!:Pedido_Detalle;
  constructor(private router:Router, private service:DetalleService){

  }

  ngOnInit(): void{
    this.Editar();
  }

  Editar(): void{
    let id=localStorage.getItem("id");
    this.service.getDetalleId(id).subscribe(data=>{
      this.detalle=data;
    })
  }

  Actualizar(detalle:Pedido_Detalle): void{
    this.service.updateDetalle(detalle).subscribe(data=>{
      this.detalle = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-detalle"])
    })
  }

  Volver(): void{
    this.router.navigate(["listar-detalle"])
  }
}
