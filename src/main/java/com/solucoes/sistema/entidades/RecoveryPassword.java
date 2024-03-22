package com.solucoes.sistema.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import com.solucoes.sistema.auditores.AuditorRecoveryPassword;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EntityListeners(AuditorRecoveryPassword.class)
@EqualsAndHashCode(of = {"id"})
@Entity
public class RecoveryPassword {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private boolean a_confirmar;
	
	@Column(nullable = true)
	private LocalDateTime data_envio;
	
	@Transient
	private long dias_vencimento;
	
	@Transient
	private String msg_vencimento;
	
	
	public RecoveryPassword() {
		this.email = "";
		this.a_confirmar = true;
		this.data_envio = LocalDateTime.now();
	}
	
	public RecoveryPassword(String email) {
		this.email = email;
		this.a_confirmar = true;
		this.data_envio = LocalDateTime.now();
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAConfirmar(boolean value) {
		this.a_confirmar = value;
	}
	
	public void setDiasVencimento(long dias) {
		this.dias_vencimento = dias;
	}
	
	public void setMensagemVencimento(String msg) {
		this.msg_vencimento = msg;
	}

	public void setData_envio(LocalDateTime data_envio) {
		this.data_envio = data_envio;
	}
	
	
}
