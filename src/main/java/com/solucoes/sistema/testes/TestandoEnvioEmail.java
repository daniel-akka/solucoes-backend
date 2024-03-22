package com.solucoes.sistema.testes;

import com.solucoes.sistema.sendmail.EnvioEmail;

public class TestandoEnvioEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnvioEmail envio = EnvioEmail.novoEnvio()
				.enviarPara("daniel.akka77@gmail.com")
				.novoTitulo("Teste de Envio de Email -  Daniel")
				.novaMensagemBody("Mensagem do Corpo do Email");
		
		boolean resultado = envio.sendEmail(); 
		
		if (resultado) {
			System.out.println("Email Enviado com Sucesso!");
		}else {
			System.out.println("Falha no envio do Email!");
		}
	}

}
