package TheBoyz.TheBoyz;

//import TheBoyz.TheBoyz.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

//@Slf4j
@SpringBootApplication
public class TheBoyzApplication {

//	private final UserRepository userRepository;
//
//	public TheBoyzApplication(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	public static void main(String[] args) {
		System.out.println("yo Momma!");
		SpringApplication.run(TheBoyzApplication.class, args);
	}

//	/**
//	 * Command line runner
//	 * @return data processed
//	 */
//	@Bean
//	public CommandLineRunner process(){
//		return (args) ->
//	}

}
