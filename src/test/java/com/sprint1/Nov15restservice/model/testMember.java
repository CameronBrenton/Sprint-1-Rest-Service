package com.sprint1.Nov15restservice.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.*;
import com.sprint1.Nov15restservice.accessingdatarest.model.PastTournament;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;

public class testMember {

    //Test Class Constructors
    @Test
    public void testDefaultConstructor(){
        Member member  = new Member();
        Assert.assertTrue(member != null);
    }

    @Test
    public void testParameterizedConstructor(){
        Member member  = new Member(new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        Assert.assertTrue(member != null);
    }

    // Test Getters

    @Test
    public void testGetID(){
        Member member  = new Member(new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        Assert.assertEquals(0, member.getId());
    }

    @Test
    public void testGetPerson(){
        Person person;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        Assert.assertSame(member.getPerson(), person);
    }

    @Test
    public void testGetMembershipStartDate(){
        Person person;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        Assert.assertTrue(Objects.equals(member.getMembershipStartDate(), LocalDate.of(2021, 11, 27)));
    }

    @Test
    public void testGetMembershipDuration(){
        Person person;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        Assert.assertTrue(Objects.equals(member.getMembershipDuration(), LocalDate.of(2022, 11, 27)));
    }

    @Test
    public void testGetMembershipType(){
        Person person;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        Assert.assertTrue(member.getMembershipType() == "Family Plan");
    }

    @Test
    public void testGetCurrentTournaments(){
        Person person;
        CurrentTournament currentTournaments;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", currentTournaments = new CurrentTournament(), new PastTournament());
        Assert.assertTrue(member.getCurrentTournaments() == currentTournaments);
    }

    @Test
    public void testGetPasTournaments(){
        Person person;
        PastTournament pastTournament;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), pastTournament =  new PastTournament());
        Assert.assertTrue(member.getPastTournaments() == pastTournament);
    }

    // Test Setters
    @Test
    public void testSetPerson(){
        Person person;
        Person newPerson;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member.setPerson(newPerson = new Person());
        Assert.assertSame(member.getPerson(), newPerson);
    }

    @Test
    public void testSetMembershipStartDate(){
        Person person;
        LocalDate newMembershipStartDate;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member.setMembershipStartDate(newMembershipStartDate = LocalDate.of(2022, 1, 1));
        Assert.assertSame(member.getMembershipStartDate(), newMembershipStartDate);
    }

    @Test
    public void testSetMembershipDuration(){
        Person person;
        LocalDate newMembershipDuration;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member.setMembershipDuration(newMembershipDuration = LocalDate.of(2023, 1, 1));
        Assert.assertSame(member.getMembershipDuration(), newMembershipDuration);
    }

    @Test
    public void testSetMembershipType(){
        Person person;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member.setMembershipType("Special Offer");
        Assert.assertSame(member.getMembershipType(), "Special Offer");
    }

    @Test
    public void testSetCurrentTournaments(){
        Person person;
        CurrentTournament newCurrentTournament;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member.setCurrentTournaments(newCurrentTournament = new CurrentTournament( LocalDate.of(2021, 11, 27),
                new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2021,6,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings())));
        Assert.assertSame(member.getCurrentTournaments(), newCurrentTournament);
    }

    @Test
    public void testSetPastTournaments(){
        Person person;
        PastTournament newPastTournament;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member.setPastTournaments(newPastTournament = new PastTournament( LocalDate.of(2021, 11, 27),
                new Tournament(LocalDate.of(2021,06,10), LocalDate.of(2020,7,20), "Rolling Hills, NL", 15.00, 350.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings())));
        Assert.assertSame(member.getPastTournaments(), newPastTournament);
    }

    @Test
    public void testSetId(){
        Person person;
        Member member  = new Member(person = new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member.setId(1);
        Assert.assertTrue(member.getId() == 1);
    }
}
