package ma.fst.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.fst.accountservice.Model.Customer;
import ma.fst.accountservice.enums.AccountType;

import java.time.LocalDate;
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long CustomerId;

}
