import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DetalleService } from 'src/app/service/detalle.service';
import { Pedido_Detalle } from 'src/app/models/pedido_detalle';

@Component({
  selector: 'app-crear-detalle',
  templateUrl: './crear-detalle.component.html',
  styleUrls: ['./crear-detalle.component.css']
})
export class CrearDetalleComponent implements OnInit{

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

  ngOnInit() {
  }

  Crear(detalle:Pedido_Detalle){
    this.service.crearDetalle(detalle).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-detalle"]);
    })
  }

  Volver(){
    this.router.navigate(["Listar-detalle"])
  }

}
