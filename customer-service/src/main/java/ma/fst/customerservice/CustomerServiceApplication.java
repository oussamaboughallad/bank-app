package ma.fst.customerservice;

import ma.fst.customerservice.config.GlobalConfig;
import ma.fst.customerservice.entities.Customer;
import ma.fst.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
			return args -> {
				List<Customer>LC=List.of(Customer.builder()
						.email("lol@lol").name("Oussama33").LastName("Boughallad").build(),Customer.builder()
						.email("lola@lola").name("Oussama11").LastName("Boughallad11").build());


				customerRepository.saveAll(LC);

			};
		}
}
