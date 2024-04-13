package ma.fst.accountservice;

import ma.fst.accountservice.clients.CustomerRestClient;
import ma.fst.accountservice.entities.BankAccount;
import ma.fst.accountservice.enums.AccountType;
import ma.fst.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(c->{
				BankAccount bankAccount1 =BankAccount.builder().balance(Math.random()*80000).createAt(LocalDate.now()).type(AccountType.Saving_Account).currency("Mad").CustomerId(c.getId()).build();
				BankAccount bankAccount2 =   BankAccount.builder().balance(Math.random()*1500).createAt(LocalDate.now()).type(AccountType.Current_Account).currency("Euro").CustomerId(c.getId()).build();
				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);
			});


		};
	}
}
