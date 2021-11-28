package com.sprint1.Nov15restservice.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class testCurrentTournament {

    //Test Constructors
    @Test
    public void testConstructor() {
        CurrentTournament currentTournament = new CurrentTournament();
        Assert.assertNotNull(currentTournament);
    }

    @Test
    public void testParameterizedConstructor() {
        CurrentTournament currentTournament = new CurrentTournament(LocalDate.of(2021, 8, 8),
                new Tournament(LocalDate.of(2021, 8, 8), LocalDate.of(2022, 7, 7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertNotNull(currentTournament);
    }

    // Test Getters
    @Test
    public void testGetId(){
        CurrentTournament currentTournament = new CurrentTournament(LocalDate.of(2021, 8, 8),
                new Tournament(LocalDate.of(2021,8,8), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(0, currentTournament.getId());
    }


    @Test
    public void testGetTournament(){
        Tournament tournament;
        CurrentTournament currentTournament = new CurrentTournament(LocalDate.of(2021, 8, 8),
                tournament = new Tournament(LocalDate.of(2021,8,8), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(tournament, currentTournament.getTournament());
    }

    @Test
    public void testGetCurrentTournamentDate(){
        CurrentTournament currentTournament = new CurrentTournament(LocalDate.of(2021, 8, 8),
                new Tournament(LocalDate.of(2021,8,8), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(LocalDate.of(2021, 8, 8), currentTournament.getCurrentTournamentDate());
    }

    // Test Setters
    @Test
    public void testSetId(){
        CurrentTournament currentTournament = new CurrentTournament(LocalDate.of(2021, 8, 8),
                new Tournament(LocalDate.of(2021,8,8), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        currentTournament.setId(15);
        Assert.assertEquals(15, currentTournament.getId());
    }


    @Test
    public void testSetCurrentTournamentDate(){
        CurrentTournament currentTournament = new CurrentTournament(LocalDate.of(2021, 8, 8),
                new Tournament(LocalDate.of(2021,8,8), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        currentTournament.setCurrentTournamentDate(LocalDate.of(2021, 8, 11));
        Assert.assertEquals(LocalDate.of(2021, 8, 11), currentTournament.getCurrentTournamentDate());
    }

    @Test
    public void testTournament(){
        Tournament newTournament;
        CurrentTournament currentTournament = new CurrentTournament(LocalDate.of(2021, 8, 8),
                new Tournament(LocalDate.of(2021,8,8), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));


        currentTournament.setTournament(newTournament = new Tournament(LocalDate.of(2021,8,4), LocalDate.of(2021,8,7),
                "The Country Club, S. John's NL", 50.00, 1500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(newTournament, currentTournament.getTournament());
    }
}