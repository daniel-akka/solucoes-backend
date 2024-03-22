package com.solucoes.sistema.servicos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucoes.sistema.entidades.Solucao;
import com.solucoes.sistema.repositorios.SolucaoRepositorio;

@Service
public class SolucaoServico {

	@Autowired
	private SolucaoRepositorio repo;
	
	public Solucao salvar(Solucao solucao) {
		repo.save(solucao);
		return solucao;
	}
	
	public void deletar(UUID id) {
		repo.deleteById(id);
	}
	
	public void deletar(Solucao solucao) {
		repo.delete(solucao);
	}
	
	public List<Solucao> buscaTodos(){
		return repo.findAll();
	}
}
