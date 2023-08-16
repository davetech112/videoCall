package com.dave.videocall;

import com.dave.videocall.user.User;
import com.dave.videocall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService service){
		return args -> {
			service.register(User.builder()
							.username("Dave")
							.email("dave@em.com")
							.password("1234")
					.build());

			service.register(User.builder()
					.username("John")
					.email("john@em.com")
					.password("1234")
					.build());

			service.register(User.builder()
					.username("Mark")
					.email("mark@em.com")
					.password("1234")
					.build());
		};
	}
}
