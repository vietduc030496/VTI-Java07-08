package com.vti.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.demo.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);
}
