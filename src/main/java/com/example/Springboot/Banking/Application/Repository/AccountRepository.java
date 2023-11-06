package com.example.Springboot.Banking.Application.Repository;

import com.example.Springboot.Banking.Application.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {
    Account findByAccountNumber(String accountNumber);
}
