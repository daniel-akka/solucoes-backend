package com.solucoes.sistema.sendmail;

import java.util.Properties;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public abstract class EmailConfig extends JavaMailSenderImpl {

	private Properties props;
	
	public EmailConfig(){
		this.setProps();
	}
	
	private void setProps() {
		this.props = this.getJavaMailProperties();
		this.props.put("mail.transport.protocol", "smtp");
	    this.props.put("mail.smtp.auth", "true");
	    this.props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	    this.props.put("mail.smtp.ssl.trust", "*");
	    this.props.put("mail.smtp.starttls.enable", "true");
	    this.props.put("mail.debug", "true");
	}
	
	public void addProps(String key, String value) {
		this.props.put(key, value);
	}
}
