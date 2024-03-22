package com.solucoes.sistema.servicos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.solucoes.sistema.dtos.consulta.RecordUsuarioLoginEmail;
import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.recursos.UsuarioRecurso;
import com.solucoes.sistema.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repo;
	
	public Usuario salvar(Usuario usuario) {
		Usuario novoUsuario = repo.save(usuario);
		novoUsuario.add(linkTo(methodOn(UsuarioRecurso.class).todos())
				.withRel("Lista de Produtos"));
		return novoUsuario;
	}
	
	public Usuario salvarTeste(Usuario usuario) {
		Usuario novoUsuario = repo.save(usuario);
		return novoUsuario;
	}
	
	public void deletar(UUID id) {
		repo.deleteById(id);
	}
	
	public void deletar(Usuario usu) {
		repo.delete(usu);
	}
	
	public List<Usuario> buscaTodos(){
		return repo.findAll();
	}
	
	public List<Usuario> buscaTodosComLink(){
		
		List<Usuario> lista_Usuarios = repo.findAll();
		
		if (!(lista_Usuarios.isEmpty())) {
			
			for (Usuario u : lista_Usuarios) {
				UUID id = u.getId();
				u.add(linkTo(methodOn(UsuarioRecurso.class).getUsuario(id)).withSelfRel());
			}
		}
		
		return lista_Usuarios;
	}
	
	public Optional<Usuario> BuscaUsuarioPorID(UUID ID) {
		
		Optional<Usuario> opt = repo.findById(ID);
		if (opt.isEmpty()) {return opt;}
		
		opt.get().add(linkTo(methodOn(UsuarioRecurso.class).todos()).withRel("Lista de Produtos"));

		return opt;
	}
	
	public List<RecordUsuarioLoginEmail> loginEmailDosUsuario(){
		return repo.loginEmailDeUsuarios();
	}
	
}
