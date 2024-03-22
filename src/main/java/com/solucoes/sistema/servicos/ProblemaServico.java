package com.solucoes.sistema.servicos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucoes.sistema.entidades.Problema;
import com.solucoes.sistema.repositorios.ProblemaRepositorio;

@Service
public class ProblemaServico {

	@Autowired
	private ProblemaRepositorio repo;
	
	public Problema salvar(Problema problema) {
		repo.save(problema);
		return problema;
	}
	
	public void deletar(UUID id) {
		repo.deleteById(id);
	}
	
	public void deletar(Problema problema) {
		repo.delete(problema);
	}
	
	public List<Problema> buscaTodos(){
		return repo.findAll();
	}
}
