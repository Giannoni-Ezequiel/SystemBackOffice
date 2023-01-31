
export class Cliente
{
  id?: number;
  tipo?: string;
  nombre: string;
  apellido: string;
  dni: string;
  razonSocial: string;
  email: string;
  direccion: string;
  cuit: string;
  telefono: string;
  fechaDeInicio: Date;
  img: string;

  constructor(nombre: string,apellido: string, dni: string,img: string,
    razonSocial: string,email: string,direccion: string,cuit: string,
    telefono: string,fechaDeInicio: Date, )
    {
      this.nombre = nombre;
      this.dni = dni;
      this.apellido = apellido;
      this.img = img;
      this.razonSocial = razonSocial;
      this.email = email;
      this.direccion = direccion;
      this.cuit = cuit;
      this.telefono = telefono;
      this.fechaDeInicio = fechaDeInicio;
    }

  /*PersonaFisica(nombre: string, dni: number,apellido: string,img: string,
                            email: string,direccion: string, telefono: string)
    {
      this.nombre = nombre;

    }*/
}
