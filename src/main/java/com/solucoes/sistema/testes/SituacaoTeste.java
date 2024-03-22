package com.solucoes.sistema.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solucoes.sistema.dtos.consulta.SituacaoRecordPesquisa;
import com.solucoes.sistema.dtos.crud.SituacaoRecordDto;
import com.solucoes.sistema.entidades.Link;
import com.solucoes.sistema.entidades.Problema;
import com.solucoes.sistema.entidades.Situacao;
import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.servicos.SituacaoServico;

@SpringBootTest
public class SituacaoTeste {

	@Autowired
	private SituacaoServico servico;
	
	
	Situacao salvandoSituacao(Usuario usu) {

		
		Situacao situacao = new Situacao(usu);
		Problema problema = new Problema(situacao);
		situacao.setResumo("ERRO QUANTIDADE NO PDV");
		problema.setDescricao("ERRO AO ADICIONAR QUANTIDADE DO PRODUTO NA TELA DO PDV");
		situacao.setProblema(problema);
		
		servico.salvar(situacao);

		return situacao;
	}
	
	
	@DisplayName("Salvando uma Situacao")
	@Test
	public void salvarSituacao() {

		SituacaoRecordDto dto = this.situacaoR();
		
		Situacao situacao = servico.criarSituacao(dto);
		
		System.out.println("Situacao Links: ");
		situacao.getProblema().getLink().forEach(l -> System.out.println(l.getUrl()));
		
		servico.salvar(situacao);
	}

	@Test
	public void ListaSituacoes() {
		List<SituacaoRecordPesquisa> situacoes = servico.buscaTodosQuerySimples();
		System.out.println("Situacoes cadastradas:");
		situacoes.forEach(System.out::println);
	}
	
	private SituacaoRecordDto situacaoR() {
		
		List<Link> links = new ArrayList<>();
		Link link1 = new Link();
		link1.setTitulo("ERRORR");
		link1.setUrl("http://link1.com");
				
		links = Arrays.asList(link1);
		
		SituacaoRecordDto sit_record = new SituacaoRecordDto(
				"3e66ee9e-5fc6-4d71-a813-0c27746220cb", 
				"Resumo do Problema", "Descriao do Problema", links);
		
		sit_record.problema_links().forEach(l -> System.out.println(l.getUrl()));
		
		return sit_record;
	}
}
