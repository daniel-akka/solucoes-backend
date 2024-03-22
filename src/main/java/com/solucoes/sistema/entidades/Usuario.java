package com.solucoes.sistema.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Component
@Table(name = "usuario", 
		uniqueConstraints = {@UniqueConstraint(columnNames = {"login", "email"})})
@Entity
public class Usuario extends RepresentationModel<Usuario> 
	implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	@Email
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Situacao> situacao = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario_master")
	private List<PermissaoGeral> permissoes_gerais = new ArrayList<>();
	

	@Override
	public String toString() {
		return "Usuario [ login=" + login + ", email=" + email + ", senha=" + senha + " ]";
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
