package com.solucoes.sistema.dtos.crud;

import java.io.File;
import java.util.List;

import com.solucoes.sistema.entidades.Link;
import com.solucoes.sistema.entidades.Situacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SolucaoDTO {

	
	private String descricao;
	private List<Link> link;
	private List<File> fotos;
	private List<File> videos;
	private List<File> documentos;
	private Situacao situacao;
}
