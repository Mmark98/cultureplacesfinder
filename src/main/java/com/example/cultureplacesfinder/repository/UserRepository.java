package com.example.cultureplacesfinder.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.cultureplacesfinder.repository.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);

}
