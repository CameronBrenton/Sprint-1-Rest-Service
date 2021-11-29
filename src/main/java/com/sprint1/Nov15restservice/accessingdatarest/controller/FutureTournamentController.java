package com.sprint1.Nov15restservice.accessingdatarest.controller;

import com.sprint1.Nov15restservice.accessingdatarest.model.FutureTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.PastTournament;
import com.sprint1.Nov15restservice.accessingdatarest.repository.FutureTournamentRepository;
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
public class FutureTournamentController {

    @Autowired
    FutureTournamentRepository futureTournamentRepository;

    @GetMapping("/futureTournaments")
    public ResponseEntity<List<FutureTournament>> getAllFutureTournaments(@RequestParam(required = false) String futureTournamentDate) {
        try {
            List<FutureTournament> futureTournament = new ArrayList<FutureTournament>();

            if (futureTournamentDate == null){
                futureTournamentRepository.findAll().forEach(futureTournament::add);
            }
            else
                futureTournamentRepository.findByFutureTournamentDate(futureTournamentDate).forEach(futureTournament::add);

            if (futureTournament.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(futureTournament, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/futureTournaments/{id}")
    public ResponseEntity<FutureTournament> getFutureTournamentById(@PathVariable("id") long id) {

        Optional<FutureTournament> futureTournament = futureTournamentRepository.findById(id);

        if (futureTournament.isPresent()){
            return new ResponseEntity<>(futureTournament.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/futureTournaments")
    public ResponseEntity<FutureTournament> postFutureTournament(@RequestBody FutureTournament futureTournament) {
        try {
            FutureTournament _futureTournament = futureTournamentRepository
                    .save(new FutureTournament(futureTournament.getFutureTournamentDate(), futureTournament.getTournament()));
            return new ResponseEntity<>(_futureTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/futureTournaments/{id}")
    public ResponseEntity<FutureTournament> updateFutureTournament(@PathVariable("id") long id, @RequestBody PastTournament futureTournament) {
        Optional<FutureTournament> futureTournamentData = futureTournamentRepository.findById(id);

        if (futureTournamentData.isPresent()) {
            FutureTournament _futureTournament = futureTournamentData.get();
            _futureTournament.setFutureTournamentDate(_futureTournament.getFutureTournamentDate());
            _futureTournament.setTournament(_futureTournament.getTournament());
            return new ResponseEntity<>(futureTournamentRepository.save(_futureTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/futureTournaments/{id}")
    public ResponseEntity<HttpStatus> deleteFutureTournament(@PathVariable("id") long id) {
        try {
            futureTournamentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
