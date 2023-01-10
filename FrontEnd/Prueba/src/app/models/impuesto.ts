export class Impuesto
{
  id?: number;
  porcentaje: number;
  nombre: string;

  constructor(id: number,porcentaje: number, nombre: string)
  {
    this.id = id;
    this.porcentaje = porcentaje;
    this.nombre = nombre;
  }
}
