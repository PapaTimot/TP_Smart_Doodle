package esir.tp.doodle.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    private String mail;
    private String name, lastname;
    @OneToOne(cascade = CascadeType.ALL)
    private Preferences preferences;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Poll> myPolls;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "participants")
    private List<Poll> othersPolls;

    public User() {
    }

    public User(String mail, String name, String lastname, Preferences preferences) {
        this.mail = mail;
        this.name = name;
        this.lastname = lastname;
        this.preferences = preferences;
        this.myPolls = new ArrayList<Poll>();
        this.othersPolls = new ArrayList<Poll>();
    }
}