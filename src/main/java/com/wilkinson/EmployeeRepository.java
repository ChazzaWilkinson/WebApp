package com.wilkinson;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	@Override
	Employee save(@Param("employee") Employee employee);

	@Override
	void delete(@Param("id") Long id);

	@Override
	void delete(@Param("employee") Employee employee);

}