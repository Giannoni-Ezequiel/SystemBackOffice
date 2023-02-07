import { Bien } from "./bien";
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
  detalles: Array<Pedido_Detalle>;

  constructor(id: number,cant: number, precioUnitario: number,precioTotal: number,descuento: number,
    garantia: number, porcGarantia: number,cargoSoporte: number,
    producto: Bien, servicio: Bien, detalles: Array<Pedido_Detalle>)
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
    this.detalles = detalles;
  }
}
