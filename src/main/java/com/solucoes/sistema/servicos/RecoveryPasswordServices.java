package com.solucoes.sistema.servicos;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucoes.sistema.entidades.RecoveryPassword;
import com.solucoes.sistema.repositorios.RecoveryPasswordRepositorio;

@Service
public class RecoveryPasswordServices {

	@Autowired
	private RecoveryPasswordRepositorio repo;
	
	public String save(RecoveryPassword recovery) {
		
		boolean existe_pedido = repo.existRecoveryPendente(recovery.getEmail());
		if (existe_pedido) {
			return "Email já foi enviado! Confira sua caixa de Entrada!";
		}
		
		repo.save(recovery); //Executa o insert
		repo.save(recovery); //Este save executa um Update com a data de envio atualizada no Auditor 
		
		return "Email enviado com sucesso! Redirecionando...";
	}
	
	public RecoveryPassword getRecoveryPassword(UUID id) {
		Optional<RecoveryPassword> recovery = repo.findById(id);
		
		
		if (recovery.isEmpty()) {
			return null;
		}
		
		repo.save(recovery.get()); //atualiza o a confirmar
		
		return recovery.get();
	}
}
