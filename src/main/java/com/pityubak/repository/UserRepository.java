package com.pityubak.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pityubak.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {

	User findByUsername(String name);
	List<User> findAll();
}
