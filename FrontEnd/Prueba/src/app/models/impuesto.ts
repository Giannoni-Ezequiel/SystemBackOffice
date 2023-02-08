export class Impuesto
{
  imp_ID!: number;
  imp_Nombre: string;
  imp_Porcentaje: number;

  constructor( imp_Nombre: string, imp_Porcentaje: number)
  {
    this.imp_Nombre = imp_Nombre;
    this.imp_Porcentaje = imp_Porcentaje;
  }
}
