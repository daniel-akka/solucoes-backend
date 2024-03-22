package com.solucoes.sistema.entidades;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Component
@Entity
public class PermissaoGeral extends RepresentationModel<PermissaoGeral> 
	implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private boolean editar;
	private boolean visualizar;
	private boolean ocultar;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_fk", referencedColumnName = "id")
	private Usuario usuario_master;
	
	@OneToOne
	@JoinColumn(name = "usuario_permitido")
	private Usuario usuario_permitido;
	
}
