package esir.tp.doodle.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> preferences;
    @ElementCollection
    private List<String> allergies;

    public Preferences(){
    }
}
