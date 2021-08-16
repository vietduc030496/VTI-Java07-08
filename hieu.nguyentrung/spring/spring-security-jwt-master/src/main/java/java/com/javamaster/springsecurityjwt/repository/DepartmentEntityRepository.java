package java.com.javamaster.springsecurityjwt.repository;

import java.com.javamaster.springsecurityjwt.entity.DepartmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentEntityRepository extends JpaRepository<DepartmentEntity, Integer> {
	
	DepartmentEntity findByName(String departmentName);
}
