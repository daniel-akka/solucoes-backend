package com.solucoes.sistema.dtos.crud;

import com.solucoes.sistema.entidades.Situacao;
import com.solucoes.sistema.entidades.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PermissaoSituacaoDTO {

	private Usuario usuario;
	private Situacao situacao;
	private boolean editar;
	private boolean visualizar;
	private boolean ocultar;
}
