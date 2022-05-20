package com.advertise.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Erro ao obter usuário por UUID"),
    MESSAGE_2("Nenhum post encontrado"),
    MESSAGE_3("Novo post adicionado com sucesso"),
    MESSAGE_4("Erro ao obter cidade e estado do usuário");

    private final String description;

}
