export class Pedido{
  Ncomprobante: string;
  fecha: Date;
  totalPedido: number;
  nomEmpEmisora: string;
  DescuentoPorcent: number;
  DescuentoTotal: number;

  constructor(Ncomprobante:string, fecha: Date,totalPedido: number,nomEmpEmisora: string,
    DescuentoPorcent: number, DescuentoTotal: number){
      this.Ncomprobante = Ncomprobante;
      this.fecha = fecha;
      this.totalPedido = totalPedido;
      this.nomEmpEmisora = nomEmpEmisora;
      this.DescuentoPorcent = DescuentoPorcent;
      this.DescuentoTotal = DescuentoTotal;
    }
}
