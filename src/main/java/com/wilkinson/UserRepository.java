package com.wilkinson;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRepository extends Repository<AdminUser, Long> {

	AdminUser save(AdminUser user);

	AdminUser findByName(String name);

}