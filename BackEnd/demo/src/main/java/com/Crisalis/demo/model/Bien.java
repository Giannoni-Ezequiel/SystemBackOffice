package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.BienDTO;
import lombok.*;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Tipo")
@DiscriminatorOptions(force = true)
@Table(name = "Bienes")
@Getter
@Setter
@ToString
public abstract class Bien {

    @Id
    @SequenceGenerator(
            name = "bien_sequence",
            sequenceName = "bien_sequence",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bien_sequence"
    )
    @Column(name = "ID")
    public Integer bien_ID;
    @Column(name = "Nombre")
    public String bien_Nombre;
    @Column(name = "Costo")
    public BigDecimal bien_Costo;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Bien_Impuesto",
            joinColumns = {
                    @JoinColumn(name = "fk_Bien")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_Impuesto")
            }
    )
    private List<Impuesto> impuestoList = new ArrayList<>();*/
    @ManyToOne(
            fetch = FetchType.EAGER
            //optional = false No puede existir un detalle sin que este en un pedido
    )
    @JoinColumn(name = "impuesto_fk")
    public Impuesto impuesto;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Cliente_bien_Servicio",
            joinColumns = {
                    @JoinColumn(name = "fk_Bien")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_Cliente")
            }
    )
    private List<Cliente> clienteList = new ArrayList<>();*/
      /*@ManyToOne(
            fetch = FetchType.EAGER
            //optional = false No puede existir un detalle sin que este en un pedido
    )
    @JoinColumn(name = "cliente_fk")
    public Cliente cliente;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL //no altere el orden de los inserts
    )
    private Set<Pedido_detalle> pedidoDetalle = new HashSet<>(); //Set permite que no se dupliquen los datos,
                                                                // no cuenta con ordenamiento

 */
    public Bien(Integer bien_ID, String bien_Nombre, BigDecimal bien_Costo, List<Integer> imp_ID) {
        this.bien_ID = bien_ID;
        this.bien_Nombre = bien_Nombre;
        this.bien_Costo = bien_Costo;
        List<Integer> imp = new ArrayList<>();
        //this.cliente = cliente;
    }
    public Bien(Integer bien_ID,String bien_Nombre, BigDecimal bien_Costo)
    {
        this.bien_ID = bien_ID;
        this.bien_Nombre = bien_Nombre;
        this.bien_Costo = bien_Costo;
    }
    public Bien(String bien_Nombre, BigDecimal bien_Costo)
    {
        this.bien_Nombre = bien_Nombre;
        this.bien_Costo = bien_Costo;
    }
    public Bien() {

    }

    //public abstract BienDTO toDTO();
    public abstract BigDecimal calcularCosto();
}
