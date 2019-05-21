package esir.tp.doodle.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title, summary;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User owner;
    private boolean meal;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> participants;
    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<UserDatesChoice> userChoices;
    @ElementCollection(targetClass = String.class)
    private List<String> dates;

    public Poll() {
    }

    public Poll(String title, String summary, User owner, boolean meal) {
        this.title = title;
        this.summary = summary;
        this.owner = owner;
        this.meal = meal;
        this.participants = new ArrayList<User>();
        this.userChoices = new ArrayList<UserDatesChoice>();
        this.dates = new ArrayList<String>();
    }

    public Poll(String title, String summary, User owner, boolean meal, List<User> participants, List<UserDatesChoice> userChoices, List<String> dates) {
        this.title = title;
        this.summary = summary;
        this.owner = owner;
        this.meal = meal;
        this.participants = participants;
        this.userChoices = userChoices;
        this.dates = dates;
    }
}
