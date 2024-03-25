package com.solucoes.sistema.dtos.crud;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record UpdateEmailSenhaRecovery(@NotBlank UUID id_recovery, 
		@NotBlank String email, @NotBlank String senha) {

}
