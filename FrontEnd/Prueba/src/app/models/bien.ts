import { Cliente } from "./cliente";
import { Impuesto } from "./impuesto";

export interface Bien
{
  id?: number;
  nombre: string;
  costo: number;
  cargoSoporte: number;
  esEspecial: boolean;
  garantia: number;
  porcentajeCarg: number;
  clientes: Array<Cliente>;
  impuestos: Array<Impuesto>;

  /*constructor(id: number, nombre: string, costo: number,cargoSoporte: number,
    esEspecial: boolean,garantia: number,porcentajeCarg: number
    )
  {
    this.id = id;
    this.nombre = nombre;
    this.costo = costo;
    this.cargoSoporte = cargoSoporte;
    this.esEspecial = esEspecial;
    this.garantia = garantia;
    this.porcentajeCarg = porcentajeCarg;

  }*/
}
