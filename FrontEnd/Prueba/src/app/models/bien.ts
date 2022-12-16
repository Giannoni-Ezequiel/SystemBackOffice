export class Bien
{
  id: number;
  nombre: string;
  costo: number;
  cargoSoporte: number;
  esEspecial: boolean;
  porcentajeCarg: number;

  constructor(id: number, nombre: string, costo: number,cargoSoporte: number,
    esEspecial: boolean,porcentajeCarg: number)
  {
    this.id = id;
    this.nombre = nombre;
    this.costo = costo;
    this.cargoSoporte = cargoSoporte;
    this.esEspecial = esEspecial;
    this.porcentajeCarg = porcentajeCarg;
  }
}
