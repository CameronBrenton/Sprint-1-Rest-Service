package com.sprint1.Nov15restservice.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class testFinalStandings {

    // Test Constructors
    @Test
    public void testConstructor(){
        FinalStandings finalStandings = new FinalStandings();
        Assert.assertTrue(finalStandings != null);
    }

    @Test
    public void testParameterizedConstructor(){
        FinalStandings finalStandings = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        Assert.assertTrue(finalStandings != null);
    }

    // Test Getters
    @Test
    public void testGetId(){
        FinalStandings finalStandings = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        Assert.assertTrue(finalStandings.getId() == 0);
    }

    @Test
    public void testGetTournament(){
        Tournament tournament;
        FinalStandings finalStandings = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                tournament = new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        Assert.assertSame(tournament, finalStandings.getTournament());
    }

    @Test
    public void testGetPerson(){
        Tournament tournament;
        Person person;
        FinalStandings finalStandings = new FinalStandings(person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                tournament = new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        Assert.assertSame(person, finalStandings.getPerson());
    }

    @Test
    public void testGetScore(){
        Tournament tournament;
        Person person;
        FinalStandings finalStandings = new FinalStandings(person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                tournament = new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        Assert.assertSame(77, finalStandings.getScore());
    }

    // Test Setters
    @Test
    public void testSetId(){
        Tournament tournament;
        Person person;
        FinalStandings finalStandings = new FinalStandings(person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                tournament = new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        finalStandings.setId(11);
        Assert.assertTrue(finalStandings.getId() == 11);
    }

    @Test
    public void testSetTournament(){
        Tournament tournament;
        Person person;
        FinalStandings finalStandings = new FinalStandings(person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                tournament = new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        finalStandings.setId(11);
        Assert.assertTrue(finalStandings.getId() == 11);
    }

    @Test
    public void testSetPerson(){
        Tournament tournament;
        Person person;
        FinalStandings finalStandings = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                tournament = new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        finalStandings.setPerson(person = new Person("Mark", "Brenton", "camcc@cam.com", "777-3333"));
        Assert.assertSame(finalStandings.getPerson(), person);
    }

    @Test
    public void testSetScore(){
        Tournament tournament;
        Person person;
        FinalStandings finalStandings = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                tournament = new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        finalStandings.setScore(80);
        Assert.assertSame(finalStandings.getScore(), 80);
    }

}
