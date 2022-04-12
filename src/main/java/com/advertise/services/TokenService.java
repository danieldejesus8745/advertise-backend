package com.advertise.services;

import com.advertise.entities.Token;
import com.advertise.repositories.TokenRepository;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ResponseModel validateToken(UUID uuid) {
        Token token = tokenRepository.findByUuid(uuid).orElse(null);

        if (Objects.isNull(token)) {
            throw new IllegalStateException("Token não encontrado");
        }

        if (System.currentTimeMillis() > token.getExpiration()) {
            tokenRepository.deleteByUuid(uuid);
            throw new IllegalStateException("Token expirado");
        }

        return new ResponseModel(200, "Token válido");
    }

    public Token findByOwner(UUID uuid) {
        return tokenRepository.findByOwner(uuid).orElse(null);
    }

}
