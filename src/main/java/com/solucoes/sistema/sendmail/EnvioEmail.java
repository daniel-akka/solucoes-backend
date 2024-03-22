package com.solucoes.sistema.sendmail;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EnvioEmail implements ISendEmail{

	private SimpleMailMessage mensagem = new SimpleMailMessage();
	private String emailDestinatario = "";
	private String titulo = "";
	private String mensagemBody = "";
	private String link = "http:/localhost:8081/RecoveryPassword/id=";
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	static public EnvioEmail novoEnvio() {
		
		return new EnvioEmail(); 
	}
	
	public EnvioEmail() {
		this.sender = this.createSenderEmail();
		this.mensagem.setFrom(this.sender.getUsername());
	}
	
	public EnvioEmail(String email) {
		
		this.emailDestinatario = email;
		this.sender = this.createSenderEmail();
		this.mensagem.setFrom(this.sender.getUsername());
		
		this.enviarPara(email);
		
	}
	
	public EnvioEmail adicionarIDAoLink(UUID id) {
		this.link += id;
		return this;
	}
	
	public EnvioEmail enviarPara(String email) {
		
		this.emailDestinatario = email;
		this.mensagem.setTo(this.emailDestinatario);
		this.titulo = "Recuperação de senha <" + this.emailDestinatario + ">";
		this.mensagem.setSubject(titulo);
		this.mensagemBody = "Segue o link para Recuperação da senha: " + this.link;
		this.novaMensagemBody(this.mensagemBody);
		
		return this;
	}
	
	public EnvioEmail novaMensagemBody(String mensagem) {
		this.mensagem.setText(mensagem);
		return this;
	}
	
	public EnvioEmail novoTitulo(String titulo) {
		this.mensagem.setSubject(titulo);
		return this;
	}
	
	public String getLink() {
		return this.link;
	}
	

	@Override
	public boolean sendEmail() {
		// TODO Auto-generated method stub
		if(sender == null) {return false;}
		
		try {
			this.sender.send(this.mensagem);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			return false;
		}
		
		
		return true;
	}
}
