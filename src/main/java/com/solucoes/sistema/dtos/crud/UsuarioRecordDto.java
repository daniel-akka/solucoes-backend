package com.solucoes.sistema.dtos.crud;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(@NotBlank String login, @NotBlank String email, 
		@NotBlank String senha) {

}
