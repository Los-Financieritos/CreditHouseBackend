package pe.upc.finanzas.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.finanzas.proyecto.entities.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad,Long> {

}
