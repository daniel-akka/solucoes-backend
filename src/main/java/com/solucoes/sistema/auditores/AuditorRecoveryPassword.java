package com.solucoes.sistema.auditores;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.solucoes.sistema.entidades.RecoveryPassword;
import com.solucoes.sistema.sendmail.EnvioEmail;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;


public class AuditorRecoveryPassword {

	
	@PostLoad
	public void atualizaAtributos(RecoveryPassword recovery) {
		//this.atualizaAconfirmar(recovery);
		this.diasVencimentoLink(recovery);
	}
	
	@PostPersist
	private void dataEnvio(RecoveryPassword recovery) {
		
		EnvioEmail.novoEnvio()
				.adicionarIDAoLink(recovery.getId())
				.enviarPara(recovery.getEmail())
				.sendEmail();
		
		recovery.setData_envio(LocalDateTime.now());
	}	
	
	private void diasVencimentoLink(RecoveryPassword recovery) {
		long dias = ChronoUnit.DAYS
				.between(recovery.getData_envio(), LocalDateTime.now());
		
		if (dias > 2) {
			recovery.setDiasVencimento(dias);
			recovery.setMensagemVencimento(
					"O prazo de 2 dias para o link venceu! Faça um novo pedido de recuperação!"); 
					
		}
	}
	

}
