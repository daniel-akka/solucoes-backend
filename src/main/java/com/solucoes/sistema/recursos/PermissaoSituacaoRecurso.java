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

import com.solucoes.sistema.dtos.crud.PermissaoSituacaoDTO;
import com.solucoes.sistema.entidades.PermissaoSituacao;
import com.solucoes.sistema.servicos.PermissaoSituacaoServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping(Paginas.permissao_situacao)
public class PermissaoSituacaoRecurso {

	@Autowired
	private PermissaoSituacaoServico servico;
	
	@PostMapping
	public PermissaoSituacao save(@Valid @RequestBody PermissaoSituacaoDTO dto) {
		PermissaoSituacao permissao = new PermissaoSituacao();
		BeanUtils.copyProperties(dto, permissao);
		return servico.salvar(permissao);
	}
	
	@GetMapping
	public ResponseEntity<List<PermissaoSituacao>> todos(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.buscaTodos());
	}
}
