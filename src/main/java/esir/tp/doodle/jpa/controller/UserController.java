package esir.tp.doodle.jpa.controller;

import esir.tp.doodle.jpa.domain.User;
import esir.tp.doodle.jpa.jpa.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/users")
    List<User> all() {
        log.info("ok");
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable String mail) {

        return repository.findByMail(mail)
                .orElseThrow(() -> new ExpressionException("User not found"));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable String mail) {

        return repository.findByMail(mail)
                .map(user -> {
                    user.setMail(newUser.getMail());
                    user.setLastname(newUser.getLastname());
                    user.setMyPolls(newUser.getMyPolls());
                    user.setName(newUser.getName());
                    user.setOthersPolls(newUser.getOthersPolls());
                    user.setPreferences(newUser.getPreferences());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setMail(mail);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable String mail) {
        repository.deleteByMail(mail);
    }
}
