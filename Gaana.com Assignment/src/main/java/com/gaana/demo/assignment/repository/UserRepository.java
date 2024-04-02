package com.gaana.demo.assignment.repository;

import com.gaana.demo.assignment.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll(Sort sort);
}
