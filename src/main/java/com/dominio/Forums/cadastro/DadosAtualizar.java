package com.dominio.Forums.cadastro;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizar(
        @NotNull
        Long id,

        String nome,
        String senha
) {
}
