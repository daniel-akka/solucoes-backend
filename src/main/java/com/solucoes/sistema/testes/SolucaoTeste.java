package com.solucoes.sistema.testes;

import org.springframework.beans.factory.annotation.Autowired;
import com.solucoes.sistema.entidades.Situacao;
import com.solucoes.sistema.entidades.Solucao;
import com.solucoes.sistema.servicos.SituacaoServico;
import com.solucoes.sistema.servicos.SolucaoServico;

public class SolucaoTeste {

	@Autowired
	public SituacaoServico serv_situacao;
	
	@Autowired
	public SolucaoServico serv_solucao;

	
	public void salvandoSolucao(Situacao situacao) {

		Solucao solucao = new Solucao(situacao);
		solucao.setDescricao("Mudar nas Configuracoes do PDV");
		serv_solucao.salvar(solucao);

	}
	
}
