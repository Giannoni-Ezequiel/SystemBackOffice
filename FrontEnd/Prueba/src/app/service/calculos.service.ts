import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BienService {
  //private Url = environment.apiBaseUrl + 'bien';

  constructor(private http:HttpClient) { }
  Url = 'http://localhost:8080/bien';
}

/*
  public calcularImpuesto(): number {
    var precioTotal = this.calcularImporte();
    var impuestoP = this.impuestoPedido.porcentaje;
    var impuestoC = this.impuestoPedido.totalImpCobrado = precioTotal *impuestoP/100;
    var precioCImpuesto = impuestoC + precioTotal;
    return precioCImpuesto;
  }// cada impuesto q puede tener un prodcuto o un servicio. pueden ser +2.

  public calcularDescuento(): number {
    if(this.cargoSoporte >= 0){
      return this.cant * this.servicio.costo;
    }
    return this.cant * this.producto.costo;
  }//Se aplica en el producto. Si el cliente tiene servicio activo se le aplica descuento. 10%. si no tiene servicio activo pero esta pidiendo uno.

  public calcularGarantia(): number {
      this.descuento = this.precioUnitario - (this.precioUnitario * this.porcGarantia / 100)
      return this.descuento;
    } //PorcGarantia producto por año de Garantia desc 0.2 porciento.

  public calcularImporte(): number {
    if(this.cargoSoporte >= 0){
      this.precioUnitario = this.calcularGarantia();
      this.precioUnitario += this.cargoSoporte;
      this.precioUnitario = this.servicio.costo;
      this.precioTotal = this.cant * this.precioUnitario;
      return this.precioTotal;
    }
    this.precioUnitario = this.calcularGarantia();
    this.precioUnitario = this.producto.costo;
    this.precioTotal = this.cant * this.precioUnitario;
    return this.precioTotal;
  }

*/
