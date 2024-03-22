package com.solucoes.sistema.recursos;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.dtos.consulta.RecordUsuarioLoginEmail;
import com.solucoes.sistema.dtos.crud.UsuarioRecordDto;
import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.servicos.UsuarioServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("newAccount")
public class CriarContaUsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<Object> getLoginEmails(){
		List<RecordUsuarioLoginEmail> usuarios = servico.loginEmailDosUsuario();
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(usuarios);
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid UsuarioRecordDto dto) {
		
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(dto, usuario);
		try {
			usuario = servico.salvar(usuario);
			return new ResponseEntity<Object>(usuario, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
