package com.tesda.bankwebapp.repositories;

import com.tesda.bankwebapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {
    User findByUsername(String username);
    User findByEmail(String email);

    User findByMobile(String mobile);
}
//@Repository
//public interface UserRepository extends CrudRepository<User, Object> {
//    User findByUsernameEmailMobile(String username, String email, String mobile);
//}