package pe.upc.finanzas.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="forms")

@Getter
@Setter
@ToString
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

    @Column(name = "sustainable", length = 2, nullable = false)
    private String sustainable;

    @Column(name = "help", length = 2, nullable = false)
    private String help;

    //Financial Data

    @Column(name = "tea", nullable = false)
    private Double tea;

    @Column(name = "sDegMensual", nullable = false)
    private Double sDegMensual;

    @Column(name = "sInmAnual", nullable = false)
    private Double sInmAnual;

    @Column(name = "time", nullable = false)
    private Long time;

    @Column(name = "grace_period", nullable = false)
    private Long grace_period;

    //Information

    @Column(name = "per_initial", nullable = false)
    private Double per_initial;

    @Column(name = "bbb", nullable = false)
    private Long bbb;

    @Column(name = "montof", nullable = false)
    private Double montof;

    @Column(name = "tcea", nullable = false)
    private Double tcea;

    @Column(name = "cuota", nullable = false)
    private Double cuota;

    public Form(Long client_id, String currency, String entity, Double price, Double initial, String sustainable, String help, Double tea, Double sDegMensual, Double sInmAnual, Long time, Long grace_period, Double per_initial, Long bbb, Double montof, Double tcea, Double cuota) {
        this.client_id = client_id;
        this.currency = currency;
        this.entity = entity;
        this.price = price;
        this.initial = initial;
        this.sustainable = sustainable;
        this.help = help;
        this.tea = tea;
        this.sDegMensual = sDegMensual;
        this.sInmAnual = sInmAnual;
        this.time = time;
        this.grace_period = grace_period;
        this.per_initial = per_initial;
        this.bbb = bbb;
        this.montof = montof;
        this.tcea = tcea;
        this.cuota = cuota;
    }

    public Form() {

    }
}
