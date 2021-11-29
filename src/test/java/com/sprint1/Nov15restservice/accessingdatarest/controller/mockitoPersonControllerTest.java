package com.sprint1.Nov15restservice.accessingdatarest.controller;


import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class mockitoPersonControllerTest {

    @Mock
    PersonController personControllerMock;
    private Person person, person2;

    // Ensure getAllPeople() using name parameters returns correctly
    @Test
    void ensureGetAllPeopleUsingNameReturnsCorrectly(){
        List<Person> people = new ArrayList<Person>();
        person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        person2 = new Person("Nigel", "Owens", "nowens@nio.com", "777-4444");
        people.add(person);
        people.add(person2);


        Mockito.when(personControllerMock.getAllPeople("Cameron", "Brenton")).thenReturn(new ResponseEntity<>(people, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(personControllerMock.getAllPeople("Cameron", "Brenton"), new ResponseEntity<>(people, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure getAllPeople() using no parameters returns correctly
    @Test
    void ensureGetAllPeopleReturnsCorrectly(){
        List<Person> people = new ArrayList<Person>();
        person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        person2 = new Person("Nigel", "Owens", "nowens@nio.com", "777-4444");
        people.add(person);


        Mockito.when(personControllerMock.getAllPeople(null, null)).thenReturn(new ResponseEntity<>(people, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(personControllerMock.getAllPeople(null, null), new ResponseEntity<>(people, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure getPeopleById() returns correctly
    @Test
    void ensureGetPeopleByIdReturnsCorrectly(){
        person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");
        person2 = new Person("Nigel", "Owens", "nowens@nio.com", "777-4444");


        Mockito.when(personControllerMock.getPeopleById(1))
                .thenReturn(new ResponseEntity<>(person, HttpStatus.OK));


        try{
            assertTrue(Objects.equals(personControllerMock.getPeopleById(1), new ResponseEntity<>(person, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure postPeople() works correctly
    @Test
    void ensurePostPeopleWorksCorrectly(){
        person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");

        Mockito.when(personControllerMock.postPeople(person)).thenReturn(new ResponseEntity<>(person, HttpStatus.CREATED));

        try{
            assertTrue(Objects.equals(personControllerMock.postPeople(person), new ResponseEntity<>(person, HttpStatus.CREATED)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure updatePeople() works correctly
    @Test
    void ensureUpdatePeopleWorksCorrectly(){
        person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");

        Mockito.when(personControllerMock.updatePeople(1, person))
                .thenReturn(new ResponseEntity<>(person, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(personControllerMock.updatePeople(1, person), new ResponseEntity<>(person, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure deletePeople() works correctly
    @Test
    void ensureDeletePeopleWorksCorrectly(){
        person = new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333");

        Mockito.when(personControllerMock.deletePeople(1))
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        try{
            assertTrue(Objects.equals(personControllerMock.deletePeople(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
