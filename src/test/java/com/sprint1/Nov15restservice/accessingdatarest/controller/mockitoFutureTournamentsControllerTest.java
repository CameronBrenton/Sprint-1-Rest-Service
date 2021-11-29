package com.sprint1.Nov15restservice.accessingdatarest.controller;

import com.sprint1.Nov15restservice.accessingdatarest.model.*;
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
public class mockitoFutureTournamentsControllerTest {
    @Mock
    FutureTournamentController futureTournamentControllerMock;
    private FutureTournament tournament, tournament2;

    // Ensure getAllFutureTournaments() returns correctly
    @Test
    void ensureGetAllFutureTournamentsReturnsCorrectly(){
        List<FutureTournament> tournaments = new ArrayList<FutureTournament>();
        tournament = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournaments.add(tournament);
        tournaments.add(tournament2);


        Mockito.when(futureTournamentControllerMock.getAllFutureTournaments(null)).thenReturn(new ResponseEntity<>(tournaments, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(futureTournamentControllerMock.getAllFutureTournaments(null), new ResponseEntity<>(tournaments, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure getFutureTournamentById() returns correctly
    @Test
    void ensureGetFutureTournamentByIdReturnsCorrectly(){
        tournament = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));

        Mockito.when(futureTournamentControllerMock.getFutureTournamentById(1)).thenReturn(new ResponseEntity<>(tournament, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(futureTournamentControllerMock.getFutureTournamentById(1), new ResponseEntity<>(tournament, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure postFutureTournament() works correctly
    @Test
    void ensurePostFutureTournamentReturnsCorrectly(){
        tournament = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));


        Mockito.when(futureTournamentControllerMock.postFutureTournament(tournament))
                .thenReturn(new ResponseEntity<>(tournament, HttpStatus.OK));


        try{
            assertTrue(Objects.equals(futureTournamentControllerMock.postFutureTournament(tournament), new ResponseEntity<>(tournament, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure updateFutureTournament() works correctly
    @Test
    void ensureUpdateFutureTournamentWorksCorrectly(){
        tournament = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));


        Mockito.when(futureTournamentControllerMock.updateFutureTournament(1, tournament)).thenReturn(new ResponseEntity<>(tournament, HttpStatus.CREATED));

        try{
            assertTrue(Objects.equals(futureTournamentControllerMock.updateFutureTournament(1, tournament), new ResponseEntity<>(tournament, HttpStatus.CREATED)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure deletePastTournament() works correctly
    @Test
    void ensureDeletePastTournamentWorksCorrectly() {
        tournament = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2021,07,07), LocalDate.of(2021,06,20), "Rolling Hills, NL", 25.00, 500.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));
        tournament2 = new FutureTournament(LocalDate.of(2021,07,07) ,new Tournament(LocalDate.of(2022,07,10), LocalDate.of(2021,07,20), "St. John's, NL", 50.00, 1000.00,
                new Person("Cameron", "Brenton", "camcc@cam.com", "777-3333"), new FinalStandings()));

        Mockito.when(futureTournamentControllerMock.deleteFutureTournament(1))
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        try {
            assertTrue(Objects.equals(futureTournamentControllerMock.deleteFutureTournament(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
