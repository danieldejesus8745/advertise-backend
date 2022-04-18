package com.advertise.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Erro ao obter UUID do usuário"),
    MESSAGE_2("Nenhum post encontrado"),
    MESSAGE_3("Novo post adicionado com sucesso");

    private final String description;

}
