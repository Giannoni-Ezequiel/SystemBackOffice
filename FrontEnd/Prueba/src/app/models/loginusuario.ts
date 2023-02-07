export class LoginUsuario
{
    id?: number;
    name: string;
    nombreUsuario: any;
    password: string;
    rol: string;

    constructor(name: string, nombreUsuario: any, password: string,  rol: string)
    {
        this.name = name;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }
}
