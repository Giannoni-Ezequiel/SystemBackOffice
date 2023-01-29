import { Cliente } from "./cliente";
import { Impuesto } from "./impuesto";

export class Bien
{
  id?: number;
  nombre: string;
  costo: number;
  cargoSoporte: number;
  esEspecial: boolean;
  garantia: number;
  porcentajeCarg: number;
  impuesto: number;
  clientes: Array<Cliente> = [];
  impuestos: Array<Impuesto> = [];

  constructor(id: number, nombre: string, costo: number,cargoSoporte: number,
    esEspecial: boolean,garantia: number,porcentajeCarg: number
    ,impuesto:number)
  {
    this.id = id;
    this.nombre = nombre;
    this.costo = costo;
    this.cargoSoporte = cargoSoporte;
    this.esEspecial = esEspecial;
    this.garantia = garantia;
    this.porcentajeCarg = porcentajeCarg;
    this.impuesto = impuesto;
  }
}
