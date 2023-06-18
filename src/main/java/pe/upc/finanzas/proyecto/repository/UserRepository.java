package pe.upc.finanzas.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.finanzas.proyecto.entities.User;

public interface UserRepository extends JpaRepository<User,Long>  {

    boolean existsByEmail(String email);
    User getUserByEmailAndPassword(String email, String password);
    boolean existsByUsername(String username);
}