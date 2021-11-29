// TournamentRepository class
package com.sprint1.Nov15restservice.accessingdatarest.repository;

import com.sprint1.Nov15restservice.accessingdatarest.model.Tournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "tournament", path = "tournament")
public interface TournamentRepository extends PagingAndSortingRepository<Tournament, Long>{
    List<Tournament> findByStartDate(@Param("startDate") String startDate);
}
