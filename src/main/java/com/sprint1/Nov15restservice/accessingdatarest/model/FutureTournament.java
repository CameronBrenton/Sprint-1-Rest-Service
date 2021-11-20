package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class FutureTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate futureTournamentDate;
    @ManyToOne
    @JoinColumn(name = "future_tournament_id")
    private Tournament tournament;

    public FutureTournament() {
    }

    public FutureTournament(LocalDate futureTournamentDate, Tournament tournament) {
        this.futureTournamentDate = futureTournamentDate;
        this.tournament = tournament;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFutureTournamentDate() {
        return futureTournamentDate;
    }

    public void setFutureTournamentDate(LocalDate futureTournamentDate) {
        this.futureTournamentDate = futureTournamentDate;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }


}
