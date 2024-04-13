package ma.fst.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.fst.accountservice.Model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customer/{id}")
    @CircuitBreaker(name="customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name="customerService",fallbackMethod ="getDefaultListCustomer" )
    List<Customer>allCustomers();

    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer =new Customer();
        customer.setId(id);
        customer.setEmail("default@default");
        customer.setLastName("default2");
        customer.setName("default1");
        return customer;
    }
    default  List<Customer> getDefaultListCustomer(Exception exception){
        return List.of();
    }

}
