package esir.tp.doodle.jpa.jpa;

import esir.tp.doodle.jpa.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long>{

}
