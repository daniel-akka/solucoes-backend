package com.solucoes.sistema.recursos;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.entidades.RecoveryPassword;
import com.solucoes.sistema.servicos.RecoveryPasswordServices;

import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("RecoveryPassword")
public class RecoveryPasswordRecurso {

	@Autowired
	private RecoveryPasswordServices servico;
	
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@RequestBody @NotBlank String email){
		
		
		try {
			servico.save(new RecoveryPassword(email));
			return ResponseEntity.status(HttpStatus.OK).body("OK");
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> getRecovery(@RequestBody @NotBlank UUID id){
		
		
		try {
			RecoveryPassword recovery = servico.getRecoveryPassword(id);
			return ResponseEntity.status(HttpStatus.OK).body(recovery);
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
}
