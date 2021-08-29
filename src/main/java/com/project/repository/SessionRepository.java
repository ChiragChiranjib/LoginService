package com.project.repository;

import com.project.model.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session,Integer> {

    public Session findByUserName(String userName);
}
