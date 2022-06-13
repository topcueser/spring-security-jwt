package com.topcueser.springsecurityjwt.controllers;

import com.topcueser.springsecurityjwt.model.User;
import com.topcueser.springsecurityjwt.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PatchMapping
    public void addRoles(@RequestBody AddRoleRequest request) {
        userService.addRoleTo(request.getUsername(), request.getRole());
    }

    @Data
    class AddRoleRequest {
        private String username;
        private String role;
    }
}
