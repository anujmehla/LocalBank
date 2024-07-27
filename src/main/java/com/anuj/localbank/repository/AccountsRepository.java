package com.anuj.localbank.repository;

import com.anuj.localbank.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    Accounts findByCustomerId(int customerId);
}
