package esir.tp.doodle.jpa.controller;

import esir.tp.doodle.jpa.domain.Poll;
import esir.tp.doodle.jpa.exception.PollNotFoundException;
import esir.tp.doodle.jpa.jpa.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class PollController {

    private final PollRepository repository;

    PollController(PollRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/polls")
    List<Poll> all() {
        log.info("ok");
        return repository.findAll();
    }

    @PostMapping("/polls")
    Poll newPoll(@RequestBody Poll newPoll) {
        return repository.save(newPoll);
    }

    // Single item

    @GetMapping("/polls/{id}")
    Poll one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PollNotFoundException(id));
    }

    @PutMapping("/polls/{id}")
    Poll replacePoll(@RequestBody Poll newPoll, @PathVariable Long id) {

        return repository.findById(id)
                .map(poll -> {
                    poll.setTitle(newPoll.getTitle());
                    poll.setMeal(newPoll.isMeal());
                    poll.setDates(newPoll.getDates());
                    poll.setOwner(newPoll.getOwner());
                    poll.setParticipants(newPoll.getParticipants());
                    poll.setSummary(newPoll.getSummary());
                    poll.setUserChoices(newPoll.getUserChoices());
                    return repository.save(poll);
                })
                .orElseGet(() -> {
                    newPoll.setId(id);
                    return repository.save(newPoll);
                });
    }

    @DeleteMapping("/polls/{id}")
    void deletePoll(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
