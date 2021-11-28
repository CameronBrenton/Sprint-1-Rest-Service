package com.sprint1.Nov15restservice.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
import com.sprint1.Nov15restservice.accessingdatarest.model.FutureTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class testFutureTournament {

    // Test Constructors
    @Test
    public void testConstructor(){
        FutureTournament futureTournament = new FutureTournament();
        Assert.assertNotNull(futureTournament);
    }

    @Test
    public void testParameterizedConstructor(){
        FutureTournament futureTournament = new FutureTournament(LocalDate.of(2022, 7, 7),
                new Tournament(LocalDate.of(2022,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertNotNull(futureTournament);
    }

    // Test Getters
    @Test
    public void testGetId(){
        FutureTournament futureTournament = new FutureTournament(LocalDate.of(2022, 7, 7),
                new Tournament(LocalDate.of(2022,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(0, futureTournament.getId());
    }

    @Test
    public void testGetFutureTournamentDate(){
        LocalDate tournamentDate;
        FutureTournament futureTournament = new FutureTournament(tournamentDate = LocalDate.of(2022, 7, 7),
                new Tournament(LocalDate.of(2022,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(tournamentDate, futureTournament.getFutureTournamentDate());
    }

    @Test
    public void testGetTournament(){
        Tournament tournament;
        FutureTournament futureTournament = new FutureTournament(LocalDate.of(2022, 7, 7),
                tournament = new Tournament(LocalDate.of(2022,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(tournament, futureTournament.getTournament());
    }

    // Test Setters
    @Test
    public void testSetId(){
        Tournament tournament;
        FutureTournament futureTournament = new FutureTournament(LocalDate.of(2022, 7, 7),
                tournament = new Tournament(LocalDate.of(2022,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(tournament, futureTournament.getTournament());
    }

    @Test
    public void testSetFutureTournamentDate(){
        FutureTournament futureTournament = new FutureTournament(LocalDate.of(2022, 7, 7),
                new Tournament(LocalDate.of(2022,7,7), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        futureTournament.setFutureTournamentDate(LocalDate.of(2022, 8, 7));
        Assert.assertEquals(LocalDate.of(2022, 8, 7), futureTournament.getFutureTournamentDate());
    }

    @Test
    public void testSetTournament(){
        Tournament tournament;
        FutureTournament futureTournament = new FutureTournament(LocalDate.of(2022, 7, 7),
                new Tournament(LocalDate.of(2022,2,2), LocalDate.of(2022,7,7),
                        "The Country Club, S. John's NL", 50.00, 1500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));

        futureTournament.setTournament(tournament = new Tournament(LocalDate.of(2022, 8, 7), LocalDate.of(2022,8,21),
                "The Country Club, S. John's NL", 50.00, 1500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        Assert.assertEquals(tournament, futureTournament.getTournament());
    }
}
