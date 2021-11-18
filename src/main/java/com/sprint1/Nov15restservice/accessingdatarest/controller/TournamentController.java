//CRUD
package com.sprint1.Nov15restservice.accessingdatarest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.repository.PersonRepository;
import com.sprint1.Nov15restservice.accessingdatarest.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping("/tournament")
    public ResponseEntity<List<Tournament>> getAllTournaments(@RequestParam(required = false) String startDate) {
        try {
            List<Tournament> tournament = new ArrayList<Tournament>();

            if (startDate == null)
                tournamentRepository.findAll().forEach(tournament::add);
            else
                tournamentRepository.findByStartDate(startDate).forEach(tournament::add);

            if (tournament.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tournament, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tournament")
    public ResponseEntity<Tournament> postTournament(@RequestBody Tournament tournament) {
        try {
            Tournament _tournament = tournamentRepository
                    .save(new Tournament(tournament.getStartDate(), tournament.getEndDate(), tournament.getLocation(), tournament.getEntryFee(), tournament.getCashPrizeAmount(), tournament.getParticipatingMembers(), tournament.getFinalStandings()));
            return new ResponseEntity<>(_tournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tournament/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable("id") long id, @RequestBody Tournament tournament) {
        Optional<Tournament> tournamentData = tournamentRepository.findById(id);

        if (tournamentData.isPresent()) {
            Tournament _tournament = tournamentData.get();
            _tournament.setStartDate(tournament.getStartDate());
            _tournament.setEndDate(tournament.getEndDate());
            _tournament.setLocation(tournament.getLocation());
            _tournament.setEntryFee(tournament.getEntryFee());
            _tournament.setCashPrizeAmount(tournament.getCashPrizeAmount());
            _tournament.setParticipatingMembers(tournament.getParticipatingMembers());
            _tournament.setFinalStandings(tournament.getFinalStandings());
            return new ResponseEntity<>(tournamentRepository.save(_tournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tournament/{id}")
    public ResponseEntity<HttpStatus> deleteTournament(@PathVariable("id") long id) {
        try {
            tournamentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
