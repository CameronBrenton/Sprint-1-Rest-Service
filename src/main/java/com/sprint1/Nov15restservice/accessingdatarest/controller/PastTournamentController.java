package com.sprint1.Nov15restservice.accessingdatarest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sprint1.Nov15restservice.accessingdatarest.model.PastTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import com.sprint1.Nov15restservice.accessingdatarest.repository.PastTournamentRepository;
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

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PastTournamentController {
    @Autowired
    PastTournamentRepository pastTournamentRepository;

    @GetMapping("/pastTournaments")
    public ResponseEntity<List<PastTournament>> getAllPastTournaments(@RequestParam(required = false) String pastTournamentDate) {
        try {
            List<PastTournament> pastTournament = new ArrayList<PastTournament>();

            if (pastTournamentDate == null){
                pastTournamentRepository.findAll().forEach(pastTournament::add);
            }
            else
                pastTournamentRepository.findByPastTournamentDate(pastTournamentDate).forEach(pastTournament::add);

            if (pastTournament.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pastTournament, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/pastTournaments/{id}")
    public ResponseEntity<PastTournament> getPastTournamentById(@PathVariable("id") long id) {

        Optional<PastTournament> pastTournamentData = pastTournamentRepository.findById(id);

        if (pastTournamentData.isPresent()){
            return new ResponseEntity<>(pastTournamentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/pastTournaments")
    public ResponseEntity<PastTournament> postPastTournament(@RequestBody PastTournament pastTournament) {
        try {
            PastTournament _pastTournament = pastTournamentRepository
                    .save(new PastTournament(pastTournament.getPastTournamentDate(), pastTournament.getTournament()));
            return new ResponseEntity<>(_pastTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pastTournaments/{id}")
    public ResponseEntity<PastTournament> updatePastTournament(@PathVariable("id") long id, @RequestBody PastTournament PastTournament) {
        Optional<PastTournament> pastTournamentData = pastTournamentRepository.findById(id);

        if (pastTournamentData.isPresent()) {
            PastTournament _pastTournament = pastTournamentData.get();
            _pastTournament.setPastTournamentDate(_pastTournament.getPastTournamentDate());
            _pastTournament.setTournament(_pastTournament.getTournament());
            return new ResponseEntity<>(pastTournamentRepository.save(_pastTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pastTournaments/{id}")
    public ResponseEntity<HttpStatus> deletePastTournament(@PathVariable("id") long id) {
        try {
            pastTournamentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
