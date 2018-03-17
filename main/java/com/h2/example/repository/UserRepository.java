package com.h2.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h2.example.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
