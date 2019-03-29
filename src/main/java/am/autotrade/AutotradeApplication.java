package am.autotrade;

import am.autotrade.entity.CarEntity;
import am.autotrade.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutotradeApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	private static final Logger log = LoggerFactory.getLogger(AutotradeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AutotradeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CarRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new CarEntity(2010, "BMW", "AAA", "AAA"));
			repository.save(new CarEntity(2010, "Mini", "BBB", "BBB"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (CarEntity customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
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
