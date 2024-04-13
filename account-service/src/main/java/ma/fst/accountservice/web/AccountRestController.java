package ma.fst.accountservice.web;

import ma.fst.accountservice.Model.Customer;
import ma.fst.accountservice.clients.CustomerRestClient;
import ma.fst.accountservice.entities.BankAccount;
import ma.fst.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;


    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> LC= bankAccountRepository.findAll();
        LC.forEach(c->{
            c.setCustomer(customerRestClient.findCustomerById(c.getCustomerId()));

        });
        return LC;
    }
    @GetMapping("/account/{id}")
    public BankAccount account(@PathVariable String id){

        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer =customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
