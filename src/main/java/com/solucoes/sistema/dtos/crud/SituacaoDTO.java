package com.solucoes.sistema.dtos.crud;

import java.util.List;
import java.util.UUID;

import com.solucoes.sistema.entidades.Link;
import com.solucoes.sistema.entidades.Situacao;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoDTO {

	@NotBlank 
	private UUID id;
	@NotBlank 
	private UUID id_usuario; 
	@NotBlank 
	private String resumo;
	@NotBlank 
	private UUID problema_id;
	@NotBlank 
	private String problema_descricao;
	
	private List<Link> problema_links;
	
	public SituacaoDTO(Situacao situacao) {
		
		this.id = situacao.getId();
		this.id_usuario = situacao.getUsuario().getId();
		this.resumo = situacao.getResumo();
		this.problema_id = situacao.getProblema().getId();
		this.problema_descricao = situacao.getProblema().getDescricao();
		this.problema_links = situacao.getProblema().getLink();

	}
}
