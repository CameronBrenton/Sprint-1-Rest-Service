package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PastTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate pastTournamentDate;
    @ManyToOne
    @JoinColumn(name = "past_tournament_id")
    private Tournament tournament;

    public PastTournament() {
    }

    public PastTournament(LocalDate pastTournamentDate, Tournament tournament) {
        this.pastTournamentDate = pastTournamentDate;
        this.tournament = tournament;
    }

    public Tournament getPastTournament() {
        return tournament;
    }

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
