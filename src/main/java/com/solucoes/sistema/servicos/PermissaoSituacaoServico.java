package com.solucoes.sistema.servicos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucoes.sistema.entidades.PermissaoSituacao;
import com.solucoes.sistema.repositorios.PermissaoSituacaoRepositorio;

@Service
public class PermissaoSituacaoServico {

	@Autowired
	private PermissaoSituacaoRepositorio repo;
	
	public PermissaoSituacao salvar(PermissaoSituacao permissao) {
		repo.save(permissao);
		return permissao;
	}
	
	public void deletar(UUID id) {
		repo.deleteById(id);
	}
	
	public void deletar(PermissaoSituacao permissao) {
		repo.delete(permissao);
	}
	
	public List<PermissaoSituacao> buscaTodos(){
		return repo.findAll();
	}
}
