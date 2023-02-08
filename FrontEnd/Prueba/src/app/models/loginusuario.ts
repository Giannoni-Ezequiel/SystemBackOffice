export class LoginUsuario
{
    id!: number;
    name: string;
    username: string;
    password: string;
    rol: string;

    constructor(name: string, username: string, password: string,  rol: string)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
}
