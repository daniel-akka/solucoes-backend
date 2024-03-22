package com.solucoes.sistema.testes;


import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.servicos.LoginServico;
import com.solucoes.sistema.servicos.UsuarioServico;


@SpringBootTest
class UsuarioTeste {

	@Autowired
	private UsuarioServico servicos;
	
	@Autowired
	private LoginServico servico_login;


	//@DisplayName("Teste de Inclusao do Usuario ****")
    @Test
    public Usuario salvandoUsuario() {
		
		Usuario daniel = new Usuario();
		daniel.setLogin("daniel");
		daniel.setEmail("daniel_akka@hotmail.com");
		daniel.setSenha("akka123");
		
		daniel =  servicos.salvarTeste(daniel);
		
		System.out.println(daniel);
		
		return daniel;
	}
    
    @Test
    public void salvarUsuario() {
		
		Usuario daniel = new Usuario();
		daniel.setLogin("daniel");
		daniel.setEmail("daniel_akka@hotmail.com");
		daniel.setSenha("akka123");
		
		daniel =  servicos.salvarTeste(daniel);
		
		System.out.println(daniel);
	}

	//@DisplayName("Teste Listando os Usuarios ****")
    @Test
    void TesteLista() {
		
		System.out.println("Todos os Usuarios:");
		servicos.buscaTodos().forEach(System.out::println);
	}
	
    
    //@DisplayName("Buscar Usuario por Email")
    @Test
    void buscaUsuarioPorEmail() {
    	Usuario usuario = servico_login.buscaUsuarioLogin("dalilacassia@hotmail.com", "dalia123");
    	System.out.println("Buscar usuario por Email e Senha:");
    	System.out.println(usuario);
    }
}
