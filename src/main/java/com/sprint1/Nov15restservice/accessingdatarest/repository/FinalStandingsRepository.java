// FinalStandingsRepository class
package com.sprint1.Nov15restservice.accessingdatarest.repository;

import com.sprint1.Nov15restservice.accessingdatarest.model.FinalStandings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "finalStandings", path = "finalStandings")
public interface FinalStandingsRepository extends PagingAndSortingRepository<FinalStandings, Long> {
    List<FinalStandings> findFinalStandingsById(@Param("id") Integer id);
}

