package co.Equipos.Equipos.repositorios;

import co.Equipos.Equipos.entidades.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoPartido extends JpaRepository<Partido,Long> {
}
