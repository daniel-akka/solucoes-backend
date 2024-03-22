package com.solucoes.sistema.dtos.crud;

import java.util.List;

import com.solucoes.sistema.entidades.Link;

import jakarta.validation.constraints.NotBlank;

public record SituacaoRecordDto(
		@NotBlank String id_usuario, 
		@NotBlank String situacao_resumo, 
		@NotBlank String problema_descricao, 
		List<Link> problema_links) {
}
