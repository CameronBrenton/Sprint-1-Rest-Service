package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Tournament{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double entryFee;
    private double cashPrizeAmount;
    @ManyToOne
    @JoinColumn(name = "participating_members_id")
    private Person participatingMembers;
    @OneToOne
    @JoinColumn(name = "final_standings_id")
    private FinalStandings finalStandings;

    public Tournament() {
    }

    public Tournament(LocalDate startDate, LocalDate endDate, String location, double entryFee, double cashPrizeAmount, Person participatingMembers, FinalStandings finalStandings) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrizeAmount = cashPrizeAmount;
        this.participatingMembers = participatingMembers;
        this.finalStandings = finalStandings;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrizeAmount() {
        return cashPrizeAmount;
    }

    public void setCashPrizeAmount(double cashPrizeAmount) {
        this.cashPrizeAmount = cashPrizeAmount;
    }

    public Person getParticipatingMembers() {
        return participatingMembers;
    }

    public void setParticipatingMembers(Person participatingMembers) {
        this.participatingMembers = participatingMembers;
    }

    public FinalStandings getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(FinalStandings finalStandings) {
        this.finalStandings = finalStandings;
    }
}
