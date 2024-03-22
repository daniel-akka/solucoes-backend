package com.solucoes.sistema.sendmail;

import org.springframework.mail.javamail.JavaMailSenderImpl;

@FunctionalInterface
public interface ISendEmail {

	boolean sendEmail();

	default JavaMailSenderImpl createSenderEmail() {
		
		String email = MeuEmail.email;
		
		if (email.contains("@gmail")) {
			return new GmailConfig(MeuEmail.email, MeuEmail.senha);
		}else if(email.contains("@hotmail") || email.contains("@outlook")){
			return new HotmailConfig(MeuEmail.email, MeuEmail.senha);
		}
		
		return null;
	}
}
