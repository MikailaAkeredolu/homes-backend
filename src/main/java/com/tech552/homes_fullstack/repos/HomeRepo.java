package com.tech552.homes_fullstack.repos;

import com.tech552.homes_fullstack.models.Home;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends CrudRepository<Home, Long> {
}
