package java.com.javamaster.springsecurityjwt.repository;

import java.com.javamaster.springsecurityjwt.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {
	EmployeeEntity findByLogin(String login);
}
