export class Cliente
{
  id?: number;
  nombre: String;
  dni: number;
  apellido: String;
  img: string;
  razonSocial: string;
  email: string;
  direccion: string;
  cuit: string;
  telefono: string;
  fechaDeInicio: Date;

  constructor(nombre: String, dni: number,apellido: String,img: string,
    razonSocial: string,email: string,direccion: string,cuit: string,telefono: string,fechaDeInicio: Date){

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

  PersonaFisica(nombre: string, dni: number,apellido: string,img: string,
                            email: string,direccion: string, telefono: string)
    {
      this.nombre = nombre;

    }
}
