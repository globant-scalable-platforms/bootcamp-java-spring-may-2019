package davidAcunaW1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import subproject.BootGradleSubApp;

@SpringBootApplication
public class BootGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootGradleApplication.class, args);
		final String output = BootGradleSubApp.greeting("SubProyecto");
	     System.out.println(output);
	}
}