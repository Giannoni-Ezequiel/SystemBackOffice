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

  constructor(id: number,cant: number, precioUnitario: number,precioTotal: number,descuento: number,
    garantia: number, porcGarantia: number,cargoSoporte: number)
  {
    this.id = id;
    this.cant = cant;
    this.precioUnitario = precioUnitario;
    this.precioTotal = precioTotal;
    this.descuento = descuento;
    this.garantia = garantia;
    this.porcGarantia = porcGarantia;
    this.cargoSoporte = cargoSoporte;
  }
}
