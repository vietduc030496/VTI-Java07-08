package com.vti.stringboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.stringboottest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
