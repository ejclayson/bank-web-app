package com.tesda.bankwebapp.repositories;

import com.tesda.bankwebapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {
    User findByUsername(String username);
}
