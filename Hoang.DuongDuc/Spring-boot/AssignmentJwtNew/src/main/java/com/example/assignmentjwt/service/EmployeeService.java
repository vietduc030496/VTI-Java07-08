package com.example.assignmentjwt.service;



import com.example.assignmentjwt.entity.Employee;
import com.example.assignmentjwt.entity.RoleEntity;
import com.example.assignmentjwt.repository.EmployeeRepo;
import com.example.assignmentjwt.repository.RoleRepo;
import com.example.assignmentjwt.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

// nhan vien sua, xem tai khoan ban than. admin, xem tat ca them nhan vien, xoa nhan vien
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo userEntityRepository;
    @Autowired
    private RoleRepo roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee saveUser(RegistrationRequest registrationRequest) {
        Employee userEntity = new Employee();
        userEntity.setPassword(registrationRequest.getPassword());
        userEntity.setLogin(registrationRequest.getLogin());

        RoleEntity userRole = roleEntityRepository.findByName(registrationRequest.getRoleName());
        if (userRole == null) {
            RoleEntity role = new RoleEntity();
            role.setName(registrationRequest.getRoleName());
            roleEntityRepository.save(role);
            userRole = roleEntityRepository.findByName(registrationRequest.getRoleName());
        }

        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public Employee findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public Employee findByLoginAndPassword(String login, String password) {
        Employee userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }







    public List<Employee> getListEmployee() {
        return (List<Employee>) userEntityRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return userEntityRepository.findById(id).orElse(null);
    }

    //    @Override hàm không tối ưu
//    public void update(int id, Employee employee) throws Exception {
//        Employee employee1 = employeeRepository.findById(id).orElse(null);
//        if(employee1 == null) throw new Exception("ID khong ton tai!");
//        employee.setId(id);
//        employeeRepository.save(employee);
//    }
    public String update(int id, Employee employee) {
        Employee employee1 = userEntityRepository.findById(id).orElse(null);
        if (employee1 == null) return "Khong ton tai ID";
        employee.setId(id);
        userEntityRepository.save(employee);
        return "Update Success";
    }

    public String delete(int id) {
        Employee employee1 = userEntityRepository.findById(id).orElse(null);
        if (employee1 == null) return "Khong ton tai ID";
        userEntityRepository.delete(employee1);
        return "Delete Success";
    }
//    public String getUserByName(String name){
//        Employee employee = new Employee();
//        employee.setId();
//    }
}
