export class Pedido_Impuesto
{
  porcentaje: number;
  totalImpCobrado: number;

  constructor(porcentaje: number, totalImpCobrado: number)
  {
    this.porcentaje = porcentaje;
    this.totalImpCobrado = totalImpCobrado;
  }
}
