package esir.tp.doodle.jpa.jpa;

import esir.tp.doodle.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default Optional<User> findByMail(String mail){
        for (User user : this.findAll()){
            if (user.getMail().equals(mail))
                return Optional.of(user);
        }
        return null;
    }

    default void deleteByMail(String mail){
        for (User user : this.findAll()){
            if (user.getMail().equals(mail)){
                //TODO
            }
        }
    }
}
