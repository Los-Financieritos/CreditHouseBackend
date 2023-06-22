package pe.upc.finanzas.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.finanzas.proyecto.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    boolean existsClientByDni(String dni);

    Client findByDni(String dni);
    Client getClientByDni(String dni);
}
