package java.com.javamaster.springsecurityjwt.config;

import java.com.javamaster.springsecurityjwt.entity.EmployeeEntity;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{

	 private String login;
	    private String password;
	    private Collection<? extends GrantedAuthority> grantedAuthorities;

	    public static CustomUserDetails fromUserEntityToCustomUserDetails(EmployeeEntity employeeEntity) {
	        CustomUserDetails c = new CustomUserDetails();
	        c.login = employeeEntity.getLogin();
	        c.password = employeeEntity.getPassword();
	        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(employeeEntity.getDepartmentEntity().getDepartmentName()));
	        return c;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return grantedAuthorities;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return login;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
