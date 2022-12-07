package model.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public  class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    private String Telefono;
    private String Email;
    private String Direccion;
    private String Img;

}
  /*
public Cliente(long id, String Telefono,String Email,String Direccion,String Img){

        this.id = id;
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

public void setTelefono(String telefono) {
        Telefono = telefono;
        }

public String getEmail() {
        return Email;
        }

public void setEmail(String email) {
        Email = email;
        }

public String getDireccion() {
        return Direccion;
        }

public void setDireccion(String direccion) {
        Direccion = direccion;
        }

public String getImg() {
        return Img;
        }

public void setImg(String img) {
        Img = img;
        }

        */