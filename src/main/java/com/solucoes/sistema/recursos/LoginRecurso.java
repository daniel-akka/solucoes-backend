package com.solucoes.sistema.recursos;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.dtos.consulta.UsuarioLogin;
import com.solucoes.sistema.servicos.LoginServico;

@RestController
@RequestMapping("/")
public class LoginRecurso {

	@Autowired
	private LoginServico servico;
	
	
	@GetMapping("/login={login_email}&senha={senha}")
	public ResponseEntity<Object> verificaLogin(@PathVariable(value = "login_email") String login_email,
			 @PathVariable(value = "senha") String senha){
		
		UsuarioLogin usuario = servico.buscaUsuarioLoginDTO(login_email, senha);
		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontado!");
		}
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(usuario);
	}
	
	@GetMapping("/id/id={id_usuario}")
	public ResponseEntity<Object> buscaUsuario(@PathVariable(value = "id_usuario") UUID id){
		
		UsuarioLogin usuario = servico.buscaUsuarioByID(id);
		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontado!");
		}
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(usuario);
	}
}
