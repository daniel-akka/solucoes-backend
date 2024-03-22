package com.solucoes.sistema.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.solucoes.sistema.sendmail.EnvioEmail;

@SpringBootTest
public class TesteEnvioEmail {

	@DisplayName("Testando o Envio do Email")
	@Test
	public void testeEnvio() {
		
		EnvioEmail envio = EnvioEmail.novoEnvio()
				.enviarPara("daniel.akka77@gmail.com")
				.novoTitulo("Teste de Envio de Email")
				.novaMensagemBody("Mensagem do Corpo");
		
		boolean resultado = envio.sendEmail();
		
		
		if (resultado) {
			System.out.println("Email Enviado com Sucesso!");
		}else {
			System.out.println("Falha no envio do Email!");
		}
	}
}
