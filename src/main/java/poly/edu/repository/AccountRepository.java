package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
