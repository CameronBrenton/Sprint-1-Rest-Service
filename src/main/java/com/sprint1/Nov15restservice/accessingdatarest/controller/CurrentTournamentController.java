// CurrentTournaments Class
package com.sprint1.Nov15restservice.accessingdatarest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.Nov15restservice.accessingdatarest.model.CurrentTournament;
import com.sprint1.Nov15restservice.accessingdatarest.repository.CurrentTournamentRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CurrentTournamentController {
    @Autowired
    CurrentTournamentRepository currentTournamentsRepository;

    // Get all CurrentTournaments
    @GetMapping("/currentTournaments")
    public ResponseEntity<List<CurrentTournament>> getAllCurrentTournaments(@RequestParam(required = false) String currentTournamentDate) {
        try {
            List<CurrentTournament> currentTournaments = new ArrayList<CurrentTournament>();

            if (currentTournamentDate == null){
                currentTournamentsRepository.findAll().forEach(currentTournaments::add);
            }
            else
                currentTournamentsRepository.findByCurrentTournamentDate(currentTournamentDate).forEach(currentTournaments::add);

            if (currentTournaments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(currentTournaments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all CurrentTournaments
    @GetMapping("/currentTournaments/{id}")
    public ResponseEntity<CurrentTournament> getCurrentTournamentById(@PathVariable("id") long id) {

        Optional<CurrentTournament> currentTournament = currentTournamentsRepository.findById(id);

        if (currentTournament.isPresent()){
            return new ResponseEntity<>(currentTournament.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Post CurrentTournaments by Id
    @PostMapping("/currentTournaments")
    public ResponseEntity<CurrentTournament> postTournament(@RequestBody CurrentTournament currentTournament) {
        try {
            CurrentTournament _currentTournament = currentTournamentsRepository
                    .save(new CurrentTournament(currentTournament.getCurrentTournamentDate(), currentTournament.getTournament()));
            return new ResponseEntity<>(_currentTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Put CurrentTournaments by id
    @PutMapping("/currentTournaments/{id}")
    public ResponseEntity<CurrentTournament> updateCurrentTournament(@PathVariable("id") long id, @RequestBody CurrentTournament currentTournament) {
        Optional<CurrentTournament> currentTournamentData = currentTournamentsRepository.findById(id);

        if (currentTournamentData.isPresent()) {
            CurrentTournament _currentTournament = currentTournamentData.get();
            _currentTournament.setCurrentTournamentDate(_currentTournament.getCurrentTournamentDate());
            _currentTournament.setTournament(_currentTournament.getTournament());
            return new ResponseEntity<>(currentTournamentsRepository.save(_currentTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete CurrentTournament by Id
    @DeleteMapping("/currentTournaments/{id}")
    public ResponseEntity<HttpStatus> deleteCurrentTournament(@PathVariable("id") long id) {
        try {
            currentTournamentsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
