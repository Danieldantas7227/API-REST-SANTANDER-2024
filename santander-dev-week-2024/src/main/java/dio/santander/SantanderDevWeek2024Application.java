package dio.santander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"model","controller" ,"repository", "service"})
@EnableJpaRepositories(basePackages = {"model", "repository", "service"})
@EntityScan(basePackages = {"model", "repository", "service", "controller"})
@SpringBootApplication
public class SantanderDevWeek2024Application {

	public static void main(String[] args) {
		SpringApplication.run(SantanderDevWeek2024Application.class, args);
	}

}
