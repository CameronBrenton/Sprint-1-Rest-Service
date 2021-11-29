package com.sprint1.Nov15restservice.accessingdatarest.controller;

import com.sprint1.Nov15restservice.accessingdatarest.model.CurrentTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
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
public class mockitoCurrentTournamentTest {


    @Mock
    CurrentTournamentController currentTournamentControllerMock;
    private CurrentTournament tournament, tournament2;

    // Ensure getAllCurrentTournaments() returns correctly
    @Test
    void ensureGetAllTournamentsReturnsCorrectly(){
        List<CurrentTournament> tournaments = new ArrayList<CurrentTournament>();
        tournament = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournaments.add(tournament);
        tournaments.add(tournament2);


        Mockito.when(currentTournamentControllerMock.getAllCurrentTournaments(null)).thenReturn(new ResponseEntity<>(tournaments, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(currentTournamentControllerMock.getAllCurrentTournaments(null), new ResponseEntity<>(tournaments, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure getCurrentTournamentById() returns correctly
    @Test
    void ensureGetTournamentByIdReturnsCorrectly(){
        tournament = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));

        Mockito.when(currentTournamentControllerMock.getCurrentTournamentById(1)).thenReturn(new ResponseEntity<>(tournament, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(currentTournamentControllerMock.getCurrentTournamentById(1), new ResponseEntity<>(tournament, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure postCurrentTournament() returns correctly
    @Test
    void ensurePostTournamentReturnsCorrectly(){
        tournament = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));


        Mockito.when(currentTournamentControllerMock.postTournament(tournament))
                .thenReturn(new ResponseEntity<>(tournament, HttpStatus.OK));


        try{
            assertTrue(Objects.equals(currentTournamentControllerMock.postTournament(tournament), new ResponseEntity<>(tournament, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure updateCurrentTournament() works correctly
    @Test
    void ensureUpdateTournamentWorksCorrectly(){
        tournament = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));


        Mockito.when(currentTournamentControllerMock.updateCurrentTournament(1, tournament)).thenReturn(new ResponseEntity<>(tournament, HttpStatus.CREATED));

        try{
            assertTrue(Objects.equals(currentTournamentControllerMock.updateCurrentTournament(1, tournament), new ResponseEntity<>(tournament, HttpStatus.CREATED)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure deleteCurrentTournament() works correctly
    @Test
    void ensureDeleteTournamentWorksCorrectly() {
        tournament = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new CurrentTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));

        Mockito.when(currentTournamentControllerMock.deleteCurrentTournament(1))
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        try {
            assertTrue(Objects.equals(currentTournamentControllerMock.deleteCurrentTournament(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
