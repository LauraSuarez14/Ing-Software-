package co.Equipos.Equipos.repositorios;

import co.ucentral.gestionador.de.notas.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEquipo extends JpaRepository<Estudiante,Long> {
}
