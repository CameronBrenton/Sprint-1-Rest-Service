package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;

@Entity
public class FinalStandings{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private int score;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
