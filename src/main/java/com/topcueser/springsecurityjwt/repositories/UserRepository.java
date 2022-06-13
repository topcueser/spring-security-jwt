package com.topcueser.springsecurityjwt.repositories;

import com.topcueser.springsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
