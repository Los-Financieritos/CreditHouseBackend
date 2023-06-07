package pe.upc.finanzas.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upc.finanzas.proyecto.entities.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long>  {

}