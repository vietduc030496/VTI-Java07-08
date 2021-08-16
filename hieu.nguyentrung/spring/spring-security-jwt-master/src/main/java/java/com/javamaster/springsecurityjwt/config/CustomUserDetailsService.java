package java.com.javamaster.springsecurityjwt.config;

import java.com.javamaster.springsecurityjwt.entity.EmployeeEntity;
import java.com.javamaster.springsecurityjwt.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService  implements UserDetailsService{

	@Autowired
    private EmployeeService employeeService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeEntity employeeEntity = employeeService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(employeeEntity);
    }

}
