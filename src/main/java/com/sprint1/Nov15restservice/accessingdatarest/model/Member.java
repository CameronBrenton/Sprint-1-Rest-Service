package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private LocalDate membershipStartDate;
    private LocalDate membershipDuration;
    private String membershipType;
    @ManyToOne
    @JoinColumn(name = "current_tournaments_id")
    private CurrentTournament currentTournaments;
    @ManyToOne
    @JoinColumn(name = "past_tournaments_id")
    private PastTournament pastTournaments;

    public Member() {
    }

    public Member(Person person, LocalDate membershipStartDate, LocalDate membershipDuration, String membershipType) {
        this.person = person;
        this.membershipStartDate = membershipStartDate;
        this.membershipDuration = membershipDuration;
        this.membershipType = membershipType;
        this.currentTournaments = null;
        this.pastTournaments = null;
    }



    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public LocalDate getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(LocalDate membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public CurrentTournament getCurrentTournaments() {
        return currentTournaments;
    }

    public void setCurrentTournaments(CurrentTournament currentTournaments) {
        this.currentTournaments = currentTournaments;
    }

    public PastTournament getPastTournaments() {
        return pastTournaments;
    }

    public void setPastTournaments(PastTournament pastTournaments) {
        this.pastTournaments = pastTournaments;
    }
}
