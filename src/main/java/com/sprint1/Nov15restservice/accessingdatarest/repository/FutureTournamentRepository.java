package com.sprint1.Nov15restservice.accessingdatarest.repository;

import com.sprint1.Nov15restservice.accessingdatarest.model.FutureTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "futureTournaments", path = "futureTournaments")
public interface FutureTournamentRepository extends PagingAndSortingRepository<FutureTournament, Long> {
    List<FutureTournament> findByFutureTournamentDate(@Param("futureTournamentDate") String futureTournamentDate);
}

