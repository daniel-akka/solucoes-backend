package com.solucoes.sistema.dtos.crud;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordCadastro(@NotBlank UUID id, @NotBlank String login, 
		@NotBlank String email, 
		@NotBlank String senha) {

}
