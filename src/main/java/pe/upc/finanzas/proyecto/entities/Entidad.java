package pe.upc.finanzas.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="entidades")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Entidad {
    @Id
    @Column(name = "ruc")
    private Long ruc;

    @Column(name="name", length=40, nullable = false)
    private String name;

    @Column(name="cinicial", nullable = false)
    private Double cinicial;

    @Column(name="mminimo", nullable = false)
    private Double mminimo;

    @Column(name="mmaximo", nullable = false)
    private Double mmaximo;

    @Column(name="tminimo", nullable = false)
    private Double tminimo;

    @Column(name="tmaximo", nullable = false)
    private Double tmaximo;

    @Column(name="plazomeses", nullable = false)
    private Long plazomeses;


}