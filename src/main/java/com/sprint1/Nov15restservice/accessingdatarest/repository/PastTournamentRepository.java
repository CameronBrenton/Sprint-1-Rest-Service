// PastTournamentsRepository class
package com.sprint1.Nov15restservice.accessingdatarest.repository;


import com.sprint1.Nov15restservice.accessingdatarest.model.PastTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "pastTournaments", path = "pastTournaments")
public interface PastTournamentRepository extends PagingAndSortingRepository<PastTournament, Long> {
    List<PastTournament> findByPastTournamentDate(@Param("pastTournamentDate") String pastTournamentDate);

}

