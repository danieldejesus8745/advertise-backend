package com.advertise.services;

import com.advertise.dto.UserDTO;
import com.advertise.entities.Token;
import com.advertise.entities.User;
import com.advertise.repositories.UserRepository;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public ResponseModel addUser(UserDTO userDTO) {
        checkIfEmailIsAlreadyRegistered(userDTO.getEmail());

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setCreatedAt(LocalDate.now());

        userRepository.save(user);

       return new ResponseModel(200, "Novo usuário cadastrado com sucesso");
    }

    public ResponseModel login(String email, String password) {
        User userFound = findUserByEmail(email);

        if (Objects.isNull(userFound)) {
            throw new IllegalStateException("Usuário não encontrado");
        }

        return new ResponseModel(
                200,
                "Login efetuado com sucesso",
                saveAndGetToken(password, userFound)
        );
    }

    private UUID saveAndGetToken(String password, User userFound) {
        if (passwordEncoder.matches(password, userFound.getPassword())) {
            Token token = new Token();
            token.setExpiration(System.currentTimeMillis() + 1200000);
            token.setOwner(userFound.getUuid());
            token.setCreatedAt(LocalDate.now());

            return tokenService.addToken(token);
        } else {
            throw new IllegalStateException("E-mail ou senha incorreta");
        }
    }

    private void checkIfEmailIsAlreadyRegistered(String email) {
        User userFound = findUserByEmail(email);

        if (Objects.nonNull(userFound)) {
            throw new IllegalStateException("Este e-mail já está cadastrado na plataforma");
        }
    }

    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

}
