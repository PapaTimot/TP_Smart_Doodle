package esir.tp.doodle.jpa.jpa;

import esir.tp.doodle.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
