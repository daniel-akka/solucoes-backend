package com.solucoes.sistema.recursos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.dtos.crud.UsuarioRecordDto;
import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.servicos.UsuarioServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Usuario")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@PostMapping("/new")
	public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioRecordDto dto) {
		
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(dto, usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(servico.salvar(usuario));
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> todos(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.buscaTodosComLink());
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Object> getUsuario(@PathVariable(value = "id") UUID id){
		Optional<Usuario> optUsuario = servico.BuscaUsuarioPorID(id);
		if (optUsuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrado!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(optUsuario.get());
	}
	
	@PutMapping("/view/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") UUID id, 
			@RequestBody @Valid UsuarioRecordDto usuarioRecordDto){
		
		Optional<Usuario> optUsuario = servico.BuscaUsuarioPorID(id);
		if (optUsuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrado!");
		}
		
		Usuario usuarioAtualizado = optUsuario.get();
		BeanUtils.copyProperties(usuarioRecordDto, usuarioAtualizado);
		
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.salvar(usuarioAtualizado));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
		
		Optional<Usuario> optUsuario = servico.BuscaUsuarioPorID(id);
		if (optUsuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrado!");
		}
		
		servico.deletar(optUsuario.get());
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("Usuario deletado com Sucesso!");
	}
}
