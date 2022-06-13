package com.topcueser.springsecurityjwt;

import com.topcueser.springsecurityjwt.model.Role;
import com.topcueser.springsecurityjwt.model.User;
import com.topcueser.springsecurityjwt.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService) {
		return args -> {
			userService.save(Role.builder().name("ROLE_USER").build());
			userService.save(Role.builder().name("ROLE_ADMIN").build());

			userService.save(User.builder().name("Emir").username("emirtopcu").password("1234").build());
			userService.addRoleTo("emirtopcu", "ROLE_USER");

			userService.save(User.builder().name("Eser").username("esertopcu").password("1234").build());
			userService.addRoleTo("esertopcu", "ROLE_USER");
			userService.addRoleTo("esertopcu", "ROLE_ADMIN");
		};
	}

}
