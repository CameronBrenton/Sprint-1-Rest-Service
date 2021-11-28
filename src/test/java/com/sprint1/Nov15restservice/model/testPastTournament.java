package com.sprint1.Nov15restservice.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
import com.sprint1.Nov15restservice.accessingdatarest.model.PastTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class testPastTournament {

    // Test Constructors
    @Test
    public void testConstructor(){
        PastTournament pastTournament = new PastTournament();
        Assert.assertTrue(pastTournament != null);
    }

    @Test
    public void testParameterizedConstructor(){
        PastTournament pastTournament = new PastTournament(LocalDate.of(2020, 7, 7),
                new Tournament(LocalDate.of(2020,7,7), LocalDate.of(2020,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertNotNull(pastTournament);
    }

    // Test Getters
    @Test
    public void testGetId(){
        PastTournament pastTournament = new PastTournament(LocalDate.of(2020, 7, 7),
                new Tournament(LocalDate.of(2020,7,7), LocalDate.of(2020,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertTrue(pastTournament.getId() == 0);
    }

    @Test
    public void testGetPastTournamentDate(){
        LocalDate pastTournamentDate;
        PastTournament pastTournament = new PastTournament(pastTournamentDate = LocalDate.of(2020, 7, 7),
                new Tournament(LocalDate.of(2020,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(pastTournamentDate, pastTournament.getPastTournamentDate());
    }

    @Test
    public void testGetTournament(){
        Tournament tournament;
        PastTournament pastTournament = new PastTournament(LocalDate.of(2020, 7, 7),
                tournament = new Tournament(LocalDate.of(2020,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(tournament, pastTournament.getTournament());
    }

    // Test Setters
    @Test
    public void testSetId(){
        PastTournament pastTournament = new PastTournament(LocalDate.of(2020, 7, 7),
                new Tournament(LocalDate.of(2020,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        pastTournament.setId(22);
        Assert.assertEquals(22, pastTournament.getId());
    }

    @Test
    public void testSetPastTournamentDate(){
        LocalDate pastTournamentDate;
        PastTournament pastTournament = new PastTournament(LocalDate.of(2020, 7, 7),
                new Tournament(LocalDate.of(2020,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        pastTournament.setPastTournamentDate(pastTournamentDate = LocalDate.of(2020, 8, 7));
        Assert.assertEquals(pastTournamentDate, pastTournament.getPastTournamentDate());
    }

    @Test
    public void testSetTournament(){
        Tournament newPastTournament;
        PastTournament pastTournament = new PastTournament(LocalDate.of(2020, 7, 7),
                new Tournament(LocalDate.of(2020,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));

        pastTournament.setTournament(newPastTournament = new Tournament(LocalDate.of(2019, 8, 7), LocalDate.of(2022,8,21),
                "The Country Club, S. John's NL", 50.00, 1500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(newPastTournament, pastTournament.getTournament());
    }
}
