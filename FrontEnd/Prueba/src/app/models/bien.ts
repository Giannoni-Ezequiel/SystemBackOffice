import { Cliente } from "./cliente";
import { Impuesto } from "./impuesto";

export class Bien
{
  id!: number;
  tipo!: string;
  nombre: string;
  costo: number;
  cargoSoporte: number;
  esEspecial: boolean;
  garantia: number;
  porcentajeGarantia: number;
  impuestos: Array<Impuesto>;

  constructor(id: number, tipo:string, nombre: string, costo: number,cargoSoporte: number,
    esEspecial: boolean,garantia: number,porcentajeGarantia: number, impuestos: Array<Impuesto>
    )
  {
    this.id = id;
    this.tipo = tipo;
    this.nombre = nombre;
    this.costo = costo;
    this.cargoSoporte = cargoSoporte;
    this.esEspecial = esEspecial;
    this.garantia = garantia;
    this.porcentajeGarantia = porcentajeGarantia;
    this.impuestos = impuestos;

  }
}
