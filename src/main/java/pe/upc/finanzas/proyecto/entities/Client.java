package pe.upc.finanzas.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="clients")

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class Client {
    //Client information
    @Id
    @Column(name = "dni")
    private Long dni;

    @Column(name = "name", length = 25, nullable = false)
    private String name;

    @Column(name = "lastname", length = 25, nullable = false)
    private String lastname;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "nationality", length = 25, nullable = false)
    private String nationality;

    @Column(name = "gender", length = 15, nullable = false)
    private String gender;

    @Column(name = "phone", length = 13, nullable = false)
    private String phone;

    @Column(name = "state_civil", length = 20, nullable = false)
    private String state_civil;

    @Column(name = "direction", length = 60, nullable = false)
    private String direction;

    //Husband/wife information

    @Column(name = "dniPartner")
    private Long dni_partner;

    @Column(name = "namePartner", length = 25, nullable = false)
    private String namePartner;

    @Column(name = "lastnamePartner", length = 25, nullable = false)
    private String lastnamePartner;

    @Column(name = "birthPartner", nullable = false)
    private Date birthPartner;

    @Column(name = "phonePartner", length = 13, nullable = false)
    private String phonePartner;

    //Laboral information

    @Column(name = "profession", length = 40, nullable = false)
    private String profession;

    @Column(name = "company", length = 40, nullable = false)
    private String company;

    @Column(name = "income")
    private Long income;
}
