package com.solucoes.sistema.dtos.consulta;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioLogin {

	private UUID id;
	private String login;
	private String email;
	private String senha;
	
	public UsuarioLogin(UUID id, String login, String email, String senha) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
	}
}
