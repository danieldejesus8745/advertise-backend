package com.advertise.services;

import com.advertise.entities.Token;
import com.advertise.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    public UUID addToken(Token token) {
        Token persistenToken = tokenRepository.save(token);

        return persistenToken.getUuid();
    }

    public void validateToken(UUID uuid) {
        Token token = tokenRepository.findByUuid(uuid).orElse(null);

        if (Objects.isNull(token)) {
            throw new IllegalStateException("Token não encontrado");
        }

        if (System.currentTimeMillis() > token.getExpiration()) {
            tokenRepository.deleteByUuid(uuid);
            throw new IllegalStateException("Token expirado");
        }
    }

}
