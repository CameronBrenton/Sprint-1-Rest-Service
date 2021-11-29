package com.sprint1.Nov15restservice.accessingdatarest.controller;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;

import com.sprint1.Nov15restservice.accessingdatarest.model.FutureTournament;
import com.sprint1.Nov15restservice.accessingdatarest.repository.FinalStandingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FinalStandingsController {
    @Autowired
    FinalStandingsRepository finalStandingsRepository;

    @GetMapping("/finalStandings")
    public ResponseEntity<List<FinalStandings>> getAllFinalStandings(@RequestParam(required = false) Integer id) {
        try {
            List<FinalStandings> finalStandings = new ArrayList<FinalStandings>();

            if (id == null){
                finalStandingsRepository.findAll().forEach(finalStandings::add);
            }
            else
                finalStandingsRepository.findFinalStandingsById(id).forEach(finalStandings::add);

            if (finalStandings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(finalStandings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/finalStandings/{id}")
    public ResponseEntity<FinalStandings> getFinalStandingsById(@PathVariable("id") long id) {

        Optional<FinalStandings> finalStandings = finalStandingsRepository.findById(id);

        if (finalStandings.isPresent()){
            return new ResponseEntity<>(finalStandings.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/finalStandings")
    public ResponseEntity<FinalStandings> postFinalStandings(@RequestBody FinalStandings finalStandings) {
        try {
            FinalStandings _finalStandings = finalStandingsRepository
                    .save(new FinalStandings(finalStandings.getPerson(), finalStandings.getTournament(), finalStandings.getScore()));
            return new ResponseEntity<>(_finalStandings, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/finalStandings/{id}")
    public ResponseEntity<FinalStandings> updateFinalStandings(@PathVariable("id") long id, @RequestBody FinalStandings finalStandings) {
        Optional<FinalStandings> finalStandingsData = finalStandingsRepository.findById(id);

        if (finalStandingsData.isPresent()) {
            FinalStandings _finalStandings = finalStandingsData.get();
            _finalStandings.setPerson(_finalStandings.getPerson());
            _finalStandings.setTournament(_finalStandings.getTournament());
            _finalStandings.setScore(_finalStandings.getScore());
            return new ResponseEntity<>(finalStandingsRepository.save(_finalStandings), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/finalStandings/{id}")
    public ResponseEntity<HttpStatus> deleteFinalStandings(@PathVariable("id") long id) {
        try {
            finalStandingsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
