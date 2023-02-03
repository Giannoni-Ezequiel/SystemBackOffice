import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DetalleService } from 'src/app/service/detalle.service';
import { Pedido_Detalle } from 'src/app/models/pedido_detalle';
import { Bien } from 'src/app/models/bien';
import { Pedido_Impuesto } from 'src/app/models/pedido_impuesto';

@Component({
  selector: 'app-crear-detalle',
  templateUrl: './crear-detalle.component.html',
  styleUrls: ['./crear-detalle.component.css']
})
export class CrearDetalleComponent implements OnInit{

  detalle!:Pedido_Detalle;
  constructor(
    private router:Router,
    private service:DetalleService){
  }

  ngOnInit(): void {
  }

  Crear(detalle:Pedido_Detalle): void{
    this.service.crearDetalle(detalle).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-detalle"]);
    })
  }

  Volver(): void{
    this.router.navigate(["listar-detalle"])
  }

}
