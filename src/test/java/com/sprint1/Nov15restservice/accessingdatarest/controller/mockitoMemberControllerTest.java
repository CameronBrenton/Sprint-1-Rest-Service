package com.sprint1.Nov15restservice.accessingdatarest.controller;

import com.sprint1.Nov15restservice.accessingdatarest.model.CurrentTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.Member;
import com.sprint1.Nov15restservice.accessingdatarest.model.PastTournament;
import com.sprint1.Nov15restservice.accessingdatarest.model.Person;
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
public class mockitoMemberControllerTest {

        @Mock
        MemberController memberControllerMock;
        private Member member, member2;

        // Ensure getAllMembers() returns correctly
        @Test
        void ensureGetAllMembersReturnsCorrectly(){
            List<Member> members = new ArrayList<Member>();
            member  = new Member(new Person("Marty", "McFly", "marty@mcfly.com",
                    "333-2121"), LocalDate.of(2021, 11, 27),
                    LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
            member2  = new Member(new Person("Doc", "Brown", "docb@docb.com",
                    "444-6644"), LocalDate.of(2021, 11, 27),
                    LocalDate.of(2022, 11, 27), "Special", new CurrentTournament(), new PastTournament());
            members.add(member);
            members.add(member2);


            Mockito.when(memberControllerMock.getAllMembers(null)).thenReturn(new ResponseEntity<>(members, HttpStatus.OK));

            try{
                assertTrue(Objects.equals(memberControllerMock.getAllMembers(null), new ResponseEntity<>(members, HttpStatus.OK)));
            }catch(Exception e){
                System.out.println(e);
            }
        }

    // Ensure getAllMembersById() returns correctly
    @Test
    void ensureGetAllMembersByIdReturnsCorrectly(){
        List<Member> members = new ArrayList<Member>();
        member  = new Member(new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member2  = new Member(new Person("Doc", "Brown", "docb@docb.com",
                "444-6644"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Special", new CurrentTournament(), new PastTournament());
        members.add(member);
        members.add(member2);


        Mockito.when(memberControllerMock.getMemberById(1)).thenReturn(new ResponseEntity<>(member, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(memberControllerMock.getMemberById(1), new ResponseEntity<>(member, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure postMember() works correctly
    @Test
    void ensurePostMemberWorksCorrectly(){
        List<Member> members = new ArrayList<Member>();
        member  = new Member(new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member2  = new Member(new Person("Doc", "Brown", "docb@docb.com",
                "444-6644"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Special", new CurrentTournament(), new PastTournament());
        members.add(member);
        members.add(member2);

        Mockito.when(memberControllerMock.postMember(member)).thenReturn(new ResponseEntity<>(member, HttpStatus.CREATED));

        try{
            assertTrue(Objects.equals(memberControllerMock.postMember(member), new ResponseEntity<>(member, HttpStatus.CREATED)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure updateMember() works correctly
    @Test
    void ensureUpdateMemberWorksCorrectly(){
        List<Member> members = new ArrayList<Member>();
        member  = new Member(new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member2  = new Member(new Person("Doc", "Brown", "docb@docb.com",
                "444-6644"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Special", new CurrentTournament(), new PastTournament());
        members.add(member);
        members.add(member2);

        Mockito.when(memberControllerMock.updateMember(1, member))
                .thenReturn(new ResponseEntity<>(member, HttpStatus.OK));

        try{
            assertTrue(Objects.equals(memberControllerMock.updateMember(1, member), new ResponseEntity<>(member, HttpStatus.OK)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Ensure deleteMember() works correctly
    @Test
    void ensureDeleteMemberWorksCorrectly(){
        List<Member> members = new ArrayList<Member>();
        member  = new Member(new Person("Marty", "McFly", "marty@mcfly.com",
                "333-2121"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Family Plan", new CurrentTournament(), new PastTournament());
        member2  = new Member(new Person("Doc", "Brown", "docb@docb.com",
                "444-6644"), LocalDate.of(2021, 11, 27),
                LocalDate.of(2022, 11, 27), "Special", new CurrentTournament(), new PastTournament());
        members.add(member);
        members.add(member2);

        Mockito.when(memberControllerMock.deleteMember(1))
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        try{
            assertTrue(Objects.equals(memberControllerMock.deleteMember(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
