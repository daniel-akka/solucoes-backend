package com.solucoes.sistema.dtos.crud;

import java.util.List;

import com.solucoes.sistema.entidades.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PermissaoGeralDTO {

	private List<Usuario> usuarios;
	private boolean editar;
	private boolean visualizar;
	private boolean ocultar;
	private Usuario usuario_master;
}
