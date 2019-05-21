package esir.tp.doodle.jpa.jpa;

import esir.tp.doodle.jpa.domain.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<Preferences, Long>{
}
