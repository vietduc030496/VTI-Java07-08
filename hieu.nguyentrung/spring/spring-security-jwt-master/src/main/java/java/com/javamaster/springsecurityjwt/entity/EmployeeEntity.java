package java.com.javamaster.springsecurityjwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee_table")
@Data
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String login;

	@Column
	private String password;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentEntity departmentEntity;
}
