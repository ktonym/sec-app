package ke.co.rhino.bima.sec;

import ke.co.rhino.bima.sec.model.User;
import ke.co.rhino.bima.sec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecApplication {

	@Autowired
	private UserRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(SecApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// username: user password: user
			repo.save(User.builder()
					.username("user")
					.password("$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi")
					.role("USER")
					.build());
			// username: admin password: admin
			repo.save(User.builder()
					.username("admin")
					.password("$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG")
					.role("ADMIN")
					.build());
		};
	}

}
