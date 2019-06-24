package foodmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class FoodmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodmanagerApplication.class, args);
	}

}
