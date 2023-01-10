import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DetalleService } from 'src/app/service/detalle.service';
import { Pedido_Detalle } from 'src/app/models/pedido_detalle';

@Component({
  selector: 'app-editar-detalle',
  templateUrl: './editar-detalle.component.html',
  styleUrls: ['./editar-detalle.component.css']
})
export class EditarDetalleComponent implements OnInit{

  detalle:Pedido_Detalle;
  constructor(private router:Router, private service:DetalleService){
    this.detalle = {
      cant: 0,
      precioUnitario: 0,
      precioTotal: 0,
      descuento: 0,
      garantia: 0,
      porcGarantia: 0,
      cargoSoporte: 0,
    }
  }

  ngOnInit(){
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getDetalleId(id).subscribe(data=>{
      this.detalle=data;
    })
  }

  Actualizar(detalle:Pedido_Detalle){
    this.service.updateDetalle(detalle).subscribe(data=>{
      this.detalle = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-detalle"])
    })
  }

  Volver(){
    this.router.navigate(["listar-detalle"])
  }
}
