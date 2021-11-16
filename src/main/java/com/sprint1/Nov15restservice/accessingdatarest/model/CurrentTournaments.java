package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CurrentTournaments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate currentTournamentDate;

    @ManyToOne
    @JoinColumn(name = "current_tournament_id")
    private Tournament tournament;

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
}
