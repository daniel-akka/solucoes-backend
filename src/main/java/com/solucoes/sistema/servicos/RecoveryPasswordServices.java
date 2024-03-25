package com.solucoes.sistema.servicos;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucoes.sistema.dtos.crud.UpdateEmailSenhaRecovery;
import com.solucoes.sistema.entidades.RecoveryPassword;
import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.repositorios.RecoveryPasswordRepositorio;

@Service
public class RecoveryPasswordServices {

	@Autowired
	private RecoveryPasswordRepositorio repo;
	
	@Autowired
	private UsuarioServico servicoUsuario;
	
	public String save(String email) {
		
		Optional<RecoveryPassword> recovery_existente = repo.existRecoveryPendente(email);
		if (recovery_existente.isEmpty() == false) {
			 
			return "Email já foi enviado! Confira sua caixa de Entrada!";
		}
		

		RecoveryPassword recovery = new RecoveryPassword(email.replace("\"", ""));
		
		repo.save(recovery); //Executa o insert
		repo.save(recovery); //Este save executa um Update com a data de envio atualizada no Auditor 
		
		return "Email enviado com sucesso! Redirecionando...";
	}
	
	public RecoveryPassword getRecoveryPassword(UUID id) {
		Optional<RecoveryPassword> recovery = repo.findById(id);
		
		
		if (recovery.isEmpty()) {
			return null;
		}
		
		//repo.save(recovery.get()); //atualiza o a confirmar
		
		return recovery.get();
	}
	
	public String updateSenhaRecovery(UpdateEmailSenhaRecovery senha_recovery) {
		
		Usuario usu = this.servicoUsuario.BuscaUsuarioPorEmail(senha_recovery.email());
		
		if (!(usu == null)) {
			
			Optional<RecoveryPassword> opt = repo.findById(senha_recovery.id_recovery());
			
			if (!(opt.isEmpty())) {
				RecoveryPassword recovery = opt.get();
				
				usu.setSenha(senha_recovery.senha());
				this.servicoUsuario.salvar(usu);
				
				recovery.setAConfirmar(false);
				repo.save(recovery);
				
				return "Senha Alterada Com Sucesso! Redirecionando...";
			}
			
		}
		
		return "Não foi possível alterar sua senha! Tente fazer um novo pedido";
	}
}
