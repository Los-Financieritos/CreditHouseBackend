package pe.upc.finanzas.proyecto.entities;

import jakarta.persistence.*;

@Entity
@Table(name="entidades")

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Entidad {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="name", length=25, nullable = false)
    private String name;

    @Column(name="lastname",length=25 , nullable = false)
    private String lastname;

    @Column(name="username", length=20, nullable = false)
    private String username;

    @Column(name="company", nullable = false)
    private String company;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    public User(String name, String lastname, String username, String company, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.company = company;
        this.email = email;
        this.password = password;
    }


}