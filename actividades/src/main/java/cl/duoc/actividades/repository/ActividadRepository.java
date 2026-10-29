package cl.duoc.actividades.repository;

import cl.duoc.actividades.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActividadRepository
        extends JpaRepository<Actividad, Long> {

    List<Actividad> findByCategoriaIgnoreCase(String categoria);
}
