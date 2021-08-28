package com.project.repository;

import com.project.model.UrlResponse;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<UrlResponse, Integer> {
}
