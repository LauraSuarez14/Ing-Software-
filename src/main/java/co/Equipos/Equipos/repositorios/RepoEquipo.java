package co.Equipos.Equipos.repositorios;

import co.Equipos.Equipos.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEquipo extends JpaRepository<Equipo,Long> {
}
