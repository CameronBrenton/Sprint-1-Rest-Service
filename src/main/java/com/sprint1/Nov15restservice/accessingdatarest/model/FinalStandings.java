// FinalStandings class
package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;

@Entity
public class FinalStandings{
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
    private int score;

    // Default Constructor
    public FinalStandings() {
    }

    //Parameterized Constructor
    public FinalStandings(Person person, Tournament tournament, int score) {
        this.person = person;
        this.tournament = tournament;
        this.score = score;
    }

    // Getters and Setters
    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
