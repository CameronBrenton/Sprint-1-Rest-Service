package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PastTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate tournamentDate;
    @ManyToOne
    @JoinColumn(name = "past_tournament_id")
    private Tournament tournament;

    public Tournament getPastTournament() {
        return tournament;
    }

    public LocalDate getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate(LocalDate tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
