package davidAcunaW3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootGradleApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.default", "dev");
		SpringApplication.run(BootGradleApplication.class, args);
	}
}