//CRUD
package com.sprint1.Nov15restservice.accessingdatarest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
import com.sprint1.Nov15restservice.accessingdatarest.repository.PersonRepository;
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

import com.sprint1.Nov15restservice.accessingdatarest.model.Member;
import com.sprint1.Nov15restservice.accessingdatarest.repository.MemberRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers(@RequestParam(required = false) Integer id) {
        try {
            List<Member> member = new ArrayList<Member>();

            if (id == null){
                memberRepository.findAll().forEach(member::add);
            }
            else
                memberRepository.findById(id).forEach(member::add);

            if (member.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(member, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/members")
    public ResponseEntity<Member> postMember(@RequestBody Member member) {
        try {
            Member _member = memberRepository
                    .save(new Member(member.getPerson(), member.getMembershipStartDate(), member.getMembershipDuration(), member.getMembershipType()));
            return new ResponseEntity<>(_member, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") long id, @RequestBody Member member) {
        Optional<Member> memberData = memberRepository.findById(id);

        if (memberData.isPresent()) {
            Member _member = memberData.get();
            _member.setPerson(member.getPerson());
            _member.setMembershipStartDate(member.getMembershipStartDate());
            _member.setCurrentTournaments(member.getCurrentTournaments());
            _member.setPastTournaments(member.getPastTournaments());
            return new ResponseEntity<>(memberRepository.save(_member), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") long id) {
        try {
            memberRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
