package com.solucoes.sistema.recursos;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.servicos.SituacaoServico;
import com.solucoes.sistema.servicos.UsuarioServico;

@RestController
@RequestMapping("home")
public class HomeRecurso {
	
	@Autowired
	private SituacaoServico situacao_servico;
	
	@Autowired
	private UsuarioServico usuario_servico;
	

	@GetMapping
	public String home() {
		return "Página Inicial da Aplicação!";
	}
	
	@GetMapping("/user_id={id}")
	public ResponseEntity<Object> listaSituacao(@PathVariable(value = "id") UUID id){
		Optional<Usuario> optU = usuario_servico.BuscaUsuarioPorID(id);
		
		if (optU.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Nenhuma Situação encontrada!");
		}
		
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(situacao_servico.situacoesPorUsuario(optU.get()));
	}
	

} 
