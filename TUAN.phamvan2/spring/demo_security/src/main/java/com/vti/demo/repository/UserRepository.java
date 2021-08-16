package com.vti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);

}
