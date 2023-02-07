export interface Impuesto
{
  id?: number;
  nombre: string;
  porcentaje: any;

  /*constructor(porcentaje: number, nombre: string)
  {
    this.porcentaje = porcentaje;
    this.nombre = nombre;
  }

  constructorPlus(id: number,porcentaje: number, nombre: string){
    this.id = id;
    this.porcentaje = porcentaje;
    this.nombre = nombre;
  }*/
}
