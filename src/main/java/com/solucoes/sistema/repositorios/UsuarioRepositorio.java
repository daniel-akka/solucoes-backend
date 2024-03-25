package com.solucoes.sistema.repositorios;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solucoes.sistema.dtos.consulta.RecordUsuarioLoginEmail;
import com.solucoes.sistema.dtos.consulta.UsuarioLogin;
import com.solucoes.sistema.dtos.crud.UsuarioRecordCadastro;
import com.solucoes.sistema.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {

	@Query("SELECT new com.solucoes.sistema.dtos.crud.UsuarioRecordCadastro("
			+ "u.id, u.login, u.email, u.senha) FROM Usuario u "
			+ "WHERE u.email LIKE ?1 AND u.senha LIKE ?2")
	List<UsuarioRecordCadastro> ConsultaSimplesDeUsuario(String email, String senha);
	
	@Query("SELECT new com.solucoes.sistema.dtos.consulta.RecordUsuarioLoginEmail("
			+ "u.login, u.email) FROM Usuario u ")
	List<RecordUsuarioLoginEmail> loginEmailDeUsuarios();
	
	@Query("SELECT u FROM Usuario u "
			+ "WHERE (u.login = :login_email OR u.email = :login_email) "
			+ "AND u.senha = :senha ")
	Usuario ConsultaLoginUsuario(@Param("login_email") String login_email, 
			@Param("senha") String senha);
	
	@Query("SELECT new com.solucoes.sistema.dtos.consulta.UsuarioLogin(u.id, "
			+ "u.login, u.email, u.senha) FROM Usuario u "
			+ "WHERE (u.login = :login_email OR u.email = :login_email) "
			+ "AND u.senha = :senha ")
	UsuarioLogin ConsultaLoginUsuarioDTO(@Param("login_email") String login_email, 
			@Param("senha") String senha);
	

	@Query("SELECT new com.solucoes.sistema.dtos.consulta.UsuarioLogin(u.id, "
			+ "u.login, u.email, u.senha) FROM Usuario u "
			+ "WHERE u.id = :id")
	UsuarioLogin usuarioLoginByID(@Param("id") UUID id);
	
	@Query("SELECT u FROM Usuario u "
			+ "WHERE u.email = :email AND u.senha = :senha")
	Usuario findUsuario(@Param("email") String email, 
			@Param("senha") String senha);
	
	@Query("SELECT u FROM Usuario u "
			+ "WHERE u.email = :email")
	Usuario findUsuarioByEmail(@Param("email") String email);
	
}
