package com.solucoes.sistema.sendmail;

public class HotmailConfig  extends EmailConfig {

	public HotmailConfig(String email, String senha){
		super();
		this.setPassword(senha);
		this.setUsername(email);
		this.setHost("smtp.office365.com");
		this.setPort(587);
		
	}
	
}
