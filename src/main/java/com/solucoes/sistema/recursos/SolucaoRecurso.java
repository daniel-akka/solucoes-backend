package com.solucoes.sistema.recursos;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.dtos.crud.SolucaoDTO;
import com.solucoes.sistema.entidades.Solucao;
import com.solucoes.sistema.servicos.SolucaoServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping(Paginas.solucoes)
public class SolucaoRecurso {

	@Autowired
	private SolucaoServico servico;
	
	
	@PostMapping
	public Solucao save(@Valid @RequestBody SolucaoDTO dto) {
		
		Solucao solucao = new Solucao();
		BeanUtils.copyProperties(dto, solucao);
		return servico.salvar(solucao);
	}
	
	@GetMapping
	public ResponseEntity<List<Solucao>> todos(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.buscaTodos());
	}
}
