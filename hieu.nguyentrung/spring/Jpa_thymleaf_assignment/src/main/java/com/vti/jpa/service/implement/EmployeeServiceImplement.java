package com.vti.jpa.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.jpa.dto.EmployeeDTO;
import com.vti.jpa.entity.Employee;
import com.vti.jpa.repository.EmployeeRepository;
import com.vti.jpa.service.EmployeeService;
import com.vti.jpa.utils.EmployeeConverterUtil;

@Service
public class EmployeeServiceImplement implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Autowired
	private EmployeeConverterUtil empConverter;


	@Override
	@Transactional
	public void addEmp(EmployeeDTO employeeDTO) {
		Employee employee = empConverter.toEntity(employeeDTO);
		employeeRepository.save(employee);
	}


	@Override
	@Transactional
	public EmployeeDTO updateEmp(long employeeID, EmployeeDTO employeeDTO) {
		Employee employee = empConverter.toEntity(employeeDTO);
		Optional<Employee> empData = employeeRepository.findById((int) employeeID);
		if(employeeDTO != null) {
			Employee emp = empData.get() ;
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			emp.setPhone(employee.getPhone());
			employeeRepository.save(emp);
		}	
		return empConverter.toDTO(employee);
		
	}


	@Override
	public List<EmployeeDTO> getEmployee() {
		List<EmployeeDTO> listDTO = new ArrayList<>();
		List<Employee> listEmployee = employeeRepository.findAll();
		
		for (Employee employee : listEmployee) {
			EmployeeDTO employeeDTO = empConverter.toDTO(employee);
			listDTO.add(employeeDTO);
		}
		return listDTO;
	}


	@Override
	public EmployeeDTO getEmployeeByID(long employeeID) {
		EmployeeDTO employeeDTO = empConverter.toDTO(employeeRepository.findById((int) employeeID).get());
		return employeeDTO;
	}



	@Override
	public List<EmployeeDTO> deleteEmpByID(long employeeID) {
		employeeRepository.deleteById((int) employeeID);
		List<EmployeeDTO> listDTO = new ArrayList<>();
		List<Employee> listEmployee = employeeRepository.findAll();
		for (Employee employee : listEmployee) {
			EmployeeDTO employeeDTO = empConverter.toDTO(employee);
			listDTO.add(employeeDTO);
		}
		return listDTO;
	}

	

}
