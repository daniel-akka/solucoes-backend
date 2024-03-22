package com.solucoes.sistema.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.UUID;

import com.solucoes.sistema.dtos.consulta.UsuarioLogin;
import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.recursos.HomeRecurso;
import com.solucoes.sistema.repositorios.UsuarioRepositorio;

@Service
public class LoginServico {

	@Autowired
	private UsuarioRepositorio repo_usuario;
	
	public Usuario buscaUsuarioLogin(String login_email, String senha) {
		
		Usuario usuario = 
				repo_usuario.ConsultaLoginUsuario(login_email, senha);
		
		if (usuario == null) {return null;}
		
		usuario.add(linkTo(methodOn(HomeRecurso.class).listaSituacao(usuario.getId()))
				.withRel("Listando Situações"));
		
		return usuario;
	}
	
	public UsuarioLogin buscaUsuarioLoginDTO(String login_email, String senha) {
		
		UsuarioLogin usuario = 
				repo_usuario.ConsultaLoginUsuarioDTO(login_email, senha);
		
		if (usuario == null) {return null;}
		
		return usuario;
	}
	
	public UsuarioLogin buscaUsuarioByID(UUID id) {
		
		UsuarioLogin usuario = 
				repo_usuario.usuarioLoginByID(id);
		
		if (usuario == null) {return null;}
		
		return usuario;
	}
}
