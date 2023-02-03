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
  impuestoPedido: Pedido_Impuesto;

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
}
