package esir.tp.doodle.jpa.jpa;

import esir.tp.doodle.jpa.domain.Poll;
import esir.tp.doodle.jpa.domain.Preferences;
import esir.tp.doodle.jpa.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PollRepository repository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Preferences p = new Preferences();
                User u = new User(
                        "user" + i + ".auto-generated@gmail.com",
                        "user" + i,
                        "auto-generated",
                        p);
                log.info("Preloading " + repository.save(new Poll(
                        "Auto-poll" + i,
                        "Auto-generated poll number " + i,
                        u,
                        i % 2 == 0)));
            }
        };
    }
}
