package com.wilkinson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;
	private final UserRepository userRepository;

	@Autowired
	public DatabaseLoader(EmployeeRepository employeeRepository, UserRepository userRepository) {
		this.employeeRepository = employeeRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		
		AdminUser charley = this.userRepository.save(new AdminUser("charley", "wilkinson",
				"ROLE_USER"));
		
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken("charley", "doesn't matter",
					AuthorityUtils.createAuthorityList("ROLE_USER")));
		
		
		this.employeeRepository.save(new Employee("Charley", "Wilkinson", "C.E.O"));
		this.employeeRepository.save(new Employee("Rupert", "Agnew", "Assistant Manager"));
		this.employeeRepository.save(new Employee("David", "Cumming", "Secretary"));
		this.employeeRepository.save(new Employee("Howard", "Hardy", "Bin Man"));
		
		SecurityContextHolder.clearContext();
	}
}
