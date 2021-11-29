// PastTournament Class
package com.sprint1.Nov15restservice.accessingdatarest.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PastTournament {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate pastTournamentDate;
    @ManyToOne
    @JoinColumn(name = "past_tournament_id")
    private Tournament tournament;

    // Default Constructor
    public PastTournament() {
    }

    // Parameterized Constructor
    public PastTournament(LocalDate pastTournamentDate, Tournament tournament) {
        this.pastTournamentDate = pastTournamentDate;
        this.tournament = tournament;
    }

    // Getters and Setters
    public LocalDate getPastTournamentDate() {
        return pastTournamentDate;
    }

    public void setPastTournamentDate(LocalDate pastTournamentDate) {
        this.pastTournamentDate = pastTournamentDate;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
