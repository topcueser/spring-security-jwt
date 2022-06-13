package com.topcueser.springsecurityjwt.services;

import com.topcueser.springsecurityjwt.model.Role;
import com.topcueser.springsecurityjwt.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    Role save(Role role);
    void addRoleTo(String username, String roleName);
    User get(String username);
    List<User> list();
}
