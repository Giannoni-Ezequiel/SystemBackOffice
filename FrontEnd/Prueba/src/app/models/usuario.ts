export class LoginUsuario
{
    id?: number;
    nombreUsuario: string;
    password: string;
    name: string;


    constructor(nombreUsuario: string, password: string, name: string){

        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.name = name;

    }
}
