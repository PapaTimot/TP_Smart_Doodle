package esir.tp.doodle.jpa.controller;

import esir.tp.doodle.jpa.domain.Preferences;
import esir.tp.doodle.jpa.jpa.PreferencesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PreferencesController {

    private final PreferencesRepository repository;

    PreferencesController(PreferencesRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/preferences")
    List<Preferences> all() {
        log.info("ok");
        return repository.findAll();
    }

    @PostMapping("/preferences")
    Preferences newPreferences(@RequestBody Preferences newPreferences) {
        return repository.save(newPreferences);
    }

    // Single item

    @GetMapping("/preferences/{id}")
    Preferences one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ExpressionException("Preference not found"));
    }

    @PutMapping("/preferences/{id}")
    Preferences replacePreferences(@RequestBody Preferences newPreferences, @PathVariable Long id) {

        return repository.findById(id)
                .map(preferences -> {
                    preferences.setAllergies(newPreferences.getAllergies());
                    preferences.setPreferences(newPreferences.getPreferences());
                    return repository.save(preferences);
                })
                .orElseGet(() -> {
                    newPreferences.setId(id);
                    return repository.save(newPreferences);
                });
    }

    @DeleteMapping("/preferences/{id}")
    void deletePreferences(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
