package com.advertise.services;

import com.advertise.dto.UserDTO;
import com.advertise.entities.User;
import com.advertise.repositories.UserRepository;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
