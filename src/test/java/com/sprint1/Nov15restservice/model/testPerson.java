package com.sprint1.Nov15restservice.model;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;

public class testPerson {

    //Test Class Constructors
    @Test
    public void testDefaultConstructor(){
        Person person  = new Person();
        Assert.assertTrue(person != null);
    }

    @Test
    public void testParameterizedConstructor(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        Assert.assertTrue(person != null);
    }

    // Test Getters

    @Test
    public void testGetID(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        Assert.assertEquals(0, person.getId());
    }

    @Test
    public void testGetFirstName(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        Assert.assertTrue(person.getFirstName() == "Cameron");
    }

    @Test
    public void testGetLastName(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        Assert.assertTrue(person.getLastName() == "Brenton");
    }

    @Test
    public void testGetEmail(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        Assert.assertTrue(person.getEmail() == "camcc@cam.com");
    }

    @Test
    public void testGetPhoneNumber(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        Assert.assertTrue(person.getPhoneNumber() == "777-3333");
    }

    // Test Setters

    @Test
    public void testSetId(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        person.setId(10);
        Assert.assertTrue(person.getId() == 10);
    }

    @Test
    public void testSetFirstName(){
        Person person  = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        person.setFirstName("Ryley");
        Assert.assertTrue(person.getFirstName() == "Ryley");
    }

    @Test
    public void testSetLastName(){
        Person person  = new Person("Ryley", "Brenton", "camcc@cam.com", "777-3333");
        person.setLastName("Owens");
        Assert.assertTrue(person.getLastName() == "Owens");
    }

    @Test
    public void testSetEmail(){
        Person person  = new Person("Ryley", "Owens", "camcc@cam.com", "777-3333");
        person.setEmail("ROwens@gmail.com");
        Assert.assertTrue(person.getEmail() == "ROwens@gmail.com");
    }

    @Test
    public void testSetPhoneNumber(){
        Person person  = new Person("Ryley", "Owens", "ROwens@gmail.com", "777-3333");
        person.setPhoneNumber("777-5555");
        Assert.assertTrue(person.getPhoneNumber() == "777-5555");
    }
}
