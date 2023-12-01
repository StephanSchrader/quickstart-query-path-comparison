package de.mnbn.quickstartquerypathcomparison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class QuickstartQueryPathComparisonApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickstartQueryPathComparisonApplication.class, args);
	}

}
