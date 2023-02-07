import { Pedido_Detalle } from "./pedido_detalle";
import { Cliente } from "./cliente";
export class Pedido
{
  id?: number;
  Ncomprobante: string;
  fecha: Date;
  totalPedido: number;
  nomEmpEmisora: string;
  DescuentoPorcent: number;
  DescuentoTotal: number;
  pedido_detalle: Array<Pedido_Detalle>;
  cliente: Cliente;

  constructor(Ncomprobante:string, fecha: Date,totalPedido: number,nomEmpEmisora: string,
    DescuentoPorcent: number, DescuentoTotal: number, cliente: Cliente, pedido_detalle: Array<Pedido_Detalle>){
      this.Ncomprobante = Ncomprobante;
      this.fecha = fecha;
      this.totalPedido = totalPedido;
      this.nomEmpEmisora = nomEmpEmisora;
      this.DescuentoPorcent = DescuentoPorcent;
      this.DescuentoTotal = DescuentoTotal;
      this.cliente = cliente;
      this.pedido_detalle = pedido_detalle;
    }

  /*public calcularTotalPedido(): number {
    while(Pedido_Detalle.length > 0){
    this.totalPedido = this.pedido_detalle.map(function(precioTotal: number) : number{
      totalPedido += precioTotal;
      return this.totalPedido += precioTotal
    })}

    return this.totalPedido;
  }

  public calcularDescuentoTotal(): number {
    this.DescuentoTotal += this.descuento
    return this.DescuentoTotal;
  }

  public calcularPorcent(): number {
    return this.DescuentoPorcent;
  }*/
}
