package ma.fst.accountservice.repository;

import ma.fst.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository  extends JpaRepository<BankAccount,String> {


}
