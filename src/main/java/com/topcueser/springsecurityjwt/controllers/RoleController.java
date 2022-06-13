package com.topcueser.springsecurityjwt.controllers;

import com.topcueser.springsecurityjwt.model.Role;
import com.topcueser.springsecurityjwt.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final UserService userService;

    public Role save(@RequestBody Role role) {
        return userService.save(role);
    }
}
