package com.keyin.tournaments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

}
