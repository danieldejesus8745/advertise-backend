package com.advertise.repositories;

import com.advertise.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {

    Optional<Token> findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);
}
