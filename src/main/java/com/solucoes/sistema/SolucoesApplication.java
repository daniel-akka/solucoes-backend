package com.solucoes.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolucoesApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/solucoes");
		SpringApplication.run(SolucoesApplication.class, args);
	}

}
