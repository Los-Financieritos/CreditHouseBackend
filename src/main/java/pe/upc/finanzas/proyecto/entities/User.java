package pe.upc.finanzas.proyecto.entities;

import jakarta.persistence.*;

@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
