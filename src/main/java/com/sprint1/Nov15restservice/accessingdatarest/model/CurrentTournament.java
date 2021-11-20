package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CurrentTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate currentTournamentDate;

    @ManyToOne
    @JoinColumn(name = "current_tournament_id")
    private Tournament tournament;

    public CurrentTournament() {
    }

    public CurrentTournament(LocalDate currentTournamentDate, Tournament tournament) {
        this.currentTournamentDate = currentTournamentDate;
        this.tournament = tournament;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public LocalDate getCurrentTournamentDate() {
        return currentTournamentDate;
    }

    public void setCurrentTournamentDate(LocalDate currentTournamentDate) {
        this.currentTournamentDate = currentTournamentDate;
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
