package com.sprint1.Nov15restservice.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;

public class testTournament {


    //Test Class Constructors
    @Test
    public void testDefaultConstructor(){
        Tournament tournament  = new Tournament();
        Assert.assertTrue(tournament != null);
    }

    @Test
    public void testParameterizedConstructor(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(tournament != null);
    }

    // Test Getters

    @Test
    public void testGetId(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(tournament.getId() != 1);
    }

    @Test
    public void testGetStartDate(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(Objects.equals(tournament.getStartDate(), LocalDate.of(2021, 06, 20)));
    }

    @Test
    public void testGetEndDate(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(Objects.equals(tournament.getEndDate(), LocalDate.of(2021, 06, 20)));
    }

    @Test
    public void testGetLocation(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(tournament.getLocation() == "Rolling Hills, NL");
    }

    @Test
    public void testGetEntryFee(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(tournament.getEntryFee() == 25.00);
    }

    // Test Setters
    @Test
    public void testGetCashPrizeAmount(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(tournament.getCashPrizeAmount() == 500.00);
    }

    @Test
    public void testGetFinalStandings(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        Assert.assertTrue(tournament.getFinalStandings() != null);
    }

    //  Test Setters

    @Test
    public void testSetId(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setId(7);
        Assert.assertTrue(tournament.getId() == 7);
    }

    @Test
    public void testSetStartDate(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setStartDate(LocalDate.of(2021,06,10));
        Assert.assertTrue(Objects.equals(tournament.getStartDate(), LocalDate.of(2021,06,10)));
    }

    @Test
    public void testSetEndDate(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setEndDate(LocalDate.of(2021,06,25));
        Assert.assertTrue(Objects.equals(tournament.getEndDate(), LocalDate.of(2021,06,25)));
    }

    @Test
    public void testSetLocation(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setLocation("McArthur's Golf Greens, NL");
        Assert.assertTrue(tournament.getLocation() == "McArthur's Golf Greens, NL");
    }

    @Test
    public void testSetEntryFree(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setEntryFee(30.00);
        Assert.assertTrue(tournament.getEntryFee() == 30.00);
    }

    @Test
    public void testSetCashPrizeAmount(){
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setCashPrizeAmount(700.00);
        Assert.assertTrue(tournament.getCashPrizeAmount() == 700.00);
    }

    @Test
    public void testSetParticipatingMembers(){
        Person lisa;
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setParticipatingMembers(lisa = new Person("Lisa", "Myers", "lisa56@lisa.com", "333-1111"));
        Assert.assertTrue(Objects.equals(tournament.getParticipatingMembers(), lisa));
    }

    @Test
    public void testSetFinalStandings(){
        FinalStandings finalStandings;
        Tournament tournament  = new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings());
        tournament.setFinalStandings(finalStandings =new FinalStandings(new Person("Lisa", "Myers", "lisa56@lisa.com", "333-1111"),
                new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 100));
        Assert.assertTrue(Objects.equals(tournament.getFinalStandings(), finalStandings));
    }

}
