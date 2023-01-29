import { Bien } from "./bien";

export class Impuesto
{
  id?: number;
  porcentaje: number;
  nombre: string;
  bien: Bien;

  constructor(id: number,porcentaje: number, nombre: string, bien: Bien)
  {
    this.id = id;
    this.porcentaje = porcentaje;
    this.nombre = nombre;
    this.bien = bien;
  }
}
