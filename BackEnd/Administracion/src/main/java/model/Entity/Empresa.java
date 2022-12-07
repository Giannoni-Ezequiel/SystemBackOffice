package model.Entity;

import javax.persistence.*;

@Entity
public class Empresa extends Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    private int CUIT;
    private String RazonSocial;
    private int FechaInicio;
    private String Telefono;
    private String Email;
    private String Direccion;
    private String Img;

    public Empresa() {
    }

    public Empresa (Long id, int CUIT, String RazonSocial, int FechaInicio,
                    String Telefono, String Email,
                    String Direccion, String Img) {
        this.id = id;
        this.CUIT = CUIT;
        this.RazonSocial = RazonSocial;
        this.FechaInicio = FechaInicio;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Direccion = Direccion;
        this.Img = Img;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }


}
