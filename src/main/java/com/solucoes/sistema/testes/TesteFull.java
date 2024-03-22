package com.solucoes.sistema.testes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solucoes.sistema.entidades.Situacao;
import com.solucoes.sistema.entidades.Usuario;

@SpringBootTest
public class TesteFull {

	@Autowired
	public UsuarioTeste testeUsuario;
	
	@Autowired
	public SituacaoTeste testeSituacao;
	
	@Autowired
	public SolucaoTeste testeSolucao;
	
	
	@Test
	public void testeCompleto() {
		
		Usuario usu = testeUsuario.salvandoUsuario();
		
		Situacao situacao = testeSituacao.salvandoSituacao(usu);
		
		testeSolucao.salvandoSolucao(situacao);
	}
}
