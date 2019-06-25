package am.autotrade;

import am.autotrade.model.Car;
import am.autotrade.model.pojo.FileStorageProperties;
import am.autotrade.service.CarService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class AutotradeApplication {

	private static final Logger log = LoggerFactory.getLogger(AutotradeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AutotradeApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CommandLineRunner demo(CarService service) {
		return (args) -> {
			// save a couple of customers
			service.saveCar(new Car(2011, "BMW", "AAA", "AAA"));
			service.saveCar(new Car(2010, "Mini", "BBB", "BBB"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Car customer : service.getAllCars()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			service.getCarById(1L)
					.ifPresent(customer -> {
						log.info("Customer found with findById(1L):");
						log.info("--------------------------------");
						log.info(customer.toString());
						log.info("");
					});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
//			repository.findByBrand("BMW").forEach(bmw -> log.info(bmw.toString()));

		};
	}

}
