package com.keyin.members;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByName(String name);
}