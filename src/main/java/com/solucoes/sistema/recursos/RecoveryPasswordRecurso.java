package com.solucoes.sistema.recursos;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.dtos.crud.UpdateEmailSenhaRecovery;
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
			String result = servico.save(email);
			if (result.toLowerCase().contains("sucesso")) {
				return ResponseEntity.status(HttpStatus.OK).body(result);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getRecovery(@PathVariable(value = "id") UUID id){
		
		
		try {
			
			RecoveryPassword recovery = servico.getRecoveryPassword(id);
			if (recovery == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO");
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(recovery);
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
	
	@PutMapping("/Update")
	public ResponseEntity<Object> alterarSenha(@RequestBody UpdateEmailSenhaRecovery update_usuario){
		
		
		try {
			String result = servico.updateSenhaRecovery(update_usuario);
			if (result.toLowerCase().contains("sucesso")) {
				return ResponseEntity.status(HttpStatus.OK).body(result);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
}
