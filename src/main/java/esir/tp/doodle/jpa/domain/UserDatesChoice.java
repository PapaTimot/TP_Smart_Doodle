package esir.tp.doodle.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserDatesChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long choiceId;
    @ElementCollection(targetClass=String.class)
    private List<String> choices;
    private String userId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Poll poll;

    public UserDatesChoice() {
    }
}
