package com.the2ang.cardmemory.repository.card;

import com.the2ang.cardmemory.entity.card.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
