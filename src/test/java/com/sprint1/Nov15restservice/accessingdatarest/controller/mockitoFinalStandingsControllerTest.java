package com.sprint1.Nov15restservice.accessingdatarest.controller;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
import com.sprint1.Nov15restservice.accessingdatarest.model.FutureTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class mockitoFinalStandingsControllerTest {
    @Mock
    FinalStandingsController finalStandingsControllerMock;
    private FinalStandings finalStandings, finalStandings1;

    // Ensure getFinalStandingsTournaments() returns correctly
    @Test
    void ensureGetAllFinalStandingsReturnsCorrectly(){
        List<FinalStandings> finalStandingsResults = new ArrayList<FinalStandings>();
        finalStandings = new FinalStandings(new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"), new FinalStandings()), 77);
        finalStandings1 = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);
        finalStandingsResults.add(finalStandings);
        finalStandingsResults.add(finalStandings1);


        Mockito.when(finalStandingsControllerMock.getAllFinalStandings(null)).thenReturn(new ResponseEntity<>(finalStandingsResults, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(finalStandingsControllerMock.getAllFinalStandings(null), new ResponseEntity<>(finalStandingsResults, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure getFinalsStandingById() returns correctly
    @Test
    void ensureGetFinalStandingsByIdReturnsCorrectly(){
        finalStandings = new FinalStandings(new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"), new FinalStandings()), 77);
        finalStandings1 = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);

        Mockito.when(finalStandingsControllerMock.getFinalStandingsById(1)).thenReturn(new ResponseEntity<>(finalStandings, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(finalStandingsControllerMock.getFinalStandingsById(1), new ResponseEntity<>(finalStandings, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure postFinalStandings() works correctly
    @Test
    void ensurePostFinalStandingsReturnsCorrectly(){
        finalStandings = new FinalStandings(new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"), new FinalStandings()), 77);
        finalStandings1 = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);


        Mockito.when(finalStandingsControllerMock.postFinalStandings(finalStandings))
                .thenReturn(new ResponseEntity<>(finalStandings, HttpStatus.OK));


        try{
            assertTrue(Objects.equals(finalStandingsControllerMock.postFinalStandings(finalStandings), new ResponseEntity<>(finalStandings, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure updateFutureTournament() works correctly
    @Test
    void ensureUpdateFinalStandingsWorksCorrectly(){
        finalStandings = new FinalStandings(new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"), new FinalStandings()), 77);
        finalStandings1 = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);


        Mockito.when(finalStandingsControllerMock.updateFinalStandings(1, finalStandings)).thenReturn(new ResponseEntity<>(finalStandings, HttpStatus.CREATED));

        try{
            assertTrue(Objects.equals(finalStandingsControllerMock.updateFinalStandings(1, finalStandings), new ResponseEntity<>(finalStandings, HttpStatus.CREATED)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure deleteFinalStandings() works correctly
    @Test
    void ensureDeleteFinalStandingsWorksCorrectly() {
        finalStandings = new FinalStandings(new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Marty", "McFly", "mmcfly@mcfly.com", "123-3333"), new FinalStandings()), 77);
        finalStandings1 = new FinalStandings(new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"),
                new Tournament(LocalDate.of(2021,6,10), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                        new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()), 77);

        Mockito.when(finalStandingsControllerMock.deleteFinalStandings(1))
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        try {
            assertTrue(Objects.equals(finalStandingsControllerMock.deleteFinalStandings(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
