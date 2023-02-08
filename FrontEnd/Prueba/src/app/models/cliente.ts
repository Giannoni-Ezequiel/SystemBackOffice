
export class Cliente
{
  id!: number;
  tipo!: string;
  nombre: string;
  apellido: string;
  dni: number;
  email: string;
  razonSocial: string;
  direccion: string;
  cuit: string;
  telefono: string;
  fechadeinicio: Date;
  persona!: Cliente;

  constructor(nombre: string,apellido: string, dni: number,
    razonSocial: string,email: string,direccion: string,cuit: string,
    telefono: string,fechadeinicio: Date)
    {

      this.nombre = nombre;
      this.dni = dni;
      this.apellido = apellido;
      this.razonSocial = razonSocial;
      this.email = email;
      this.direccion = direccion;
      this.cuit = cuit;
      this.telefono = telefono;
      this.fechadeinicio = fechadeinicio;
    }

  /*PersonaFisica(nombre: string, dni: number,apellido: string,img: string,
                            email: string,direccion: string, telefono: string)
    {
      this.nombre = nombre;

    }*/
}
