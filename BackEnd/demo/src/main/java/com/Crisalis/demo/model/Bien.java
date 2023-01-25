package com.Crisalis.demo.model;

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
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer bien_ID;
    @Column(name = "Nombre")
    private String bien_Nombre;
    @Column(name = "Costo")
    private BigDecimal bien_Costo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Bien_Impuesto",
            joinColumns = {
                    @JoinColumn(name = "fk_Bien")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_Impuesto")
            }
    )
    private List<Impuesto> impuestoList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Cliente_bien_Servicio",
            joinColumns = {
                    @JoinColumn(name = "fk_Bien")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_Cliente")
            }
    )
    private List<Cliente> clienteList = new ArrayList<>();
    /*
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL //no altere el orden de los inserts
    )
    private Set<Pedido_detalle> pedidoDetalle = new HashSet<>(); //Set permite que no se dupliquen los datos,
                                                                // no cuenta con ordenamiento

 */
}
