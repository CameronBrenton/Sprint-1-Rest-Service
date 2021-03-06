// Member Class
package com.sprint1.Nov15restservice.accessingdatarest.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {
    // Instance Variables
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

    // Default Constructor
    public Member() {
    }

    // Parameterized Constructor
    public Member(Person person, LocalDate membershipStartDate, LocalDate membershipDuration, String membershipType, CurrentTournament currentTournament, PastTournament pastTournament) {
        this.person = person;
        this.membershipStartDate = membershipStartDate;
        this.membershipDuration = membershipDuration;
        this.membershipType = membershipType;
        this.currentTournaments = currentTournament;
        this.pastTournaments = pastTournament;
    }


    // Setters and Getters
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
