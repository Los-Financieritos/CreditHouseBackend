package pe.upc.finanzas.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="forms")

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Form {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="form_id")
    private Long form_id;

    @Column(name = "client_id", nullable = false)
    private Long client_id;

    @Column(name = "currency", length = 25, nullable = false)
    private String currency;

    @Column(name = "entity", length = 25, nullable = false)
    private String entity;

    //Place Data

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "initial", nullable = false)
    private Double initial;

    @Column(name = "sustainable", nullable = false)
    private Boolean sustainable;

    @Column(name = "help",nullable = false)
    private Boolean  help;

    //Financial Data

    @Column(name = "tea", nullable = false)
    private Double tea;

    @Column(name = "s_deg_mensual", nullable = false)
    private Double sDegMensual;

    @Column(name = "s_inm_anual", nullable = false)
    private Double sInmAnual;

    @Column(name = "time", nullable = false)
    private Long time;

    @Column(name = "tipo", length = 10, nullable = true)
    private String tipo;

    @Column(name = "grace_period", nullable = true)
    private Long gracePeriod;

    //Information

    @Column(name = "per_initial", nullable = false)
    private Double perInitial;

    @Column(name = "bbp", nullable = false)
    private Double bbp;

    @Column(name = "montof", nullable = false)
    private Double montof;

    @Column(name = "tcea", nullable = false)
    private Double tcea;

    @Column(name = "cuota", nullable = false)
    private Double cuota;

    @Column(name = "asesor", length = 50, nullable = false)
    private String asesor;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

}
