package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    private String Nombre;
    private String Apellido;
    private int DNI;
    private int CUIT;
    private String RazonSocial;
    private int FechaInicio;
    private String Telefono;
    private String Email;
    private String Direccion;
    private String Img;


    public Cliente () {}

    public Cliente (Long id, String Nombre, String Apellido, int DNI,
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

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }

    public int getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Cliente (Long id, int CUIT, String RazonSocial, int FechaInicio,
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