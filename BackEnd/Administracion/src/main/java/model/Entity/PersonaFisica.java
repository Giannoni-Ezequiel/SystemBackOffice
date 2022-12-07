package model.Entity;

import javax.persistence.*;

@Entity
public class PersonaFisica extends Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    private String Nombre;
    private String Apellido;
    private int DNI;
    private String Telefono;
    private String Email;
    private String Direccion;
    private String Img;

    public PersonaFisica(){}

    public PersonaFisica (Long id, String Nombre, String Apellido, int DNI,
                    String Email, String Telefono, String Direccion, String Img){
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Email = Email;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Img = Img;

    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }






}


