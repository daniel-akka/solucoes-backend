package com.solucoes.sistema.sendmail;

public class GmailConfig extends EmailConfig{

	public GmailConfig(String email, String senha){
		super();
		this.setPassword(senha);
		this.setUsername(email);
		super.setHost("smtp.gmail.com"); //smtp.gmail.com
		super.setPort(587);
		
	}
	
}
