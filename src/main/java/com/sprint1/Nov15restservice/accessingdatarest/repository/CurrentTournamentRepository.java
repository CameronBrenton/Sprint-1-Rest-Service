package com.sprint1.Nov15restservice.accessingdatarest.repository;

import com.sprint1.Nov15restservice.accessingdatarest.model.CurrentTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "currentTournaments", path = "currentTournaments")
public interface CurrentTournamentRepository extends PagingAndSortingRepository<CurrentTournament, Long> {
    List<CurrentTournament> findByCurrentTournamentDate(@Param("currentTournamentDate") String currentTournamentDate);
}

