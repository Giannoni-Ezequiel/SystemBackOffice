import { Bien } from "./bien";
import { Pedido_Impuesto } from "./pedido_impuesto"
export class Pedido_Detalle
{
  id?: number;
  cant: number;
  precioUnitario: number;
  precioTotal: number;
  descuento: number;
  garantia: number;
  porcGarantia: number;
  cargoSoporte: number;
  producto: Bien;
  servicio: Bien;
  impuestoPedido: Pedido_Impuesto

  constructor(id: number,cant: number, precioUnitario: number,precioTotal: number,descuento: number,
    garantia: number, porcGarantia: number,cargoSoporte: number,
    producto: Bien, servicio: Bien, impuestoPedido: Pedido_Impuesto)
  {
    this.id = id;
    this.cant = cant;
    this.precioUnitario = precioUnitario;
    this.precioTotal = precioTotal;
    this.descuento = descuento;
    this.garantia = garantia;
    this.porcGarantia = porcGarantia;
    this.cargoSoporte = cargoSoporte;
    this.producto = producto;
    this.servicio = servicio;
    this.impuestoPedido = impuestoPedido;
  }

  public calcularImpuesto(): number {
    var precioTotal = this.calcularImporte();
    var impuestoP = this.impuestoPedido.porcentaje;
    var impuestoC = this.impuestoPedido.totalImpCobrado = precioTotal *impuestoP/100;
    var precioCImpuesto = impuestoC + precioTotal;
    return precioCImpuesto;
  }

  public calcularDescuento(): number {
    if(this.cargoSoporte >= 0){
      return this.cant * this.servicio.costo;
    }
    return this.cant * this.producto.costo;
  }

  public calcularGarantia(): number {
      this.descuento = this.precioUnitario - (this.precioUnitario * this.porcGarantia / 100)
      return this.descuento;
    }

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


}
