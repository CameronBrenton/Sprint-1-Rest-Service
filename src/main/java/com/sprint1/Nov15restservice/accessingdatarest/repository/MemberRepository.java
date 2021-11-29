// MemberRepository class
package com.sprint1.Nov15restservice.accessingdatarest.repository;

import com.sprint1.Nov15restservice.accessingdatarest.model.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "members", path = "members")
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
    List<Member> findById(@Param("id") Integer id);
}
