package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Bien_Impuesto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bien_Impuesto {

    @ManyToOne
    @JoinColumn(name = "imp_ID")
    private Integer imp_ID;
    @ManyToOne
    @JoinColumn(name = "bien_ID")
    private Integer bien_ID;
}
