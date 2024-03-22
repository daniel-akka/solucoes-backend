package com.solucoes.sistema.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Component
@Entity
public class Problema extends RepresentationModel<Problema> 
	implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private String descricao;

	@ElementCollection
	private List<Link> link;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "situacao_fk", referencedColumnName = "id")
	private Situacao situacao;
	
	@Lob
	@Column(nullable = true)
	@Basic(fetch = FetchType.LAZY)
	@ElementCollection
	private List<byte[]> fotos = new ArrayList<>();
	
	@Lob
	@Column(nullable = true)
	@Basic(fetch = FetchType.LAZY)
	@ElementCollection
	private List<byte[]> videos = new ArrayList<>();
	
	@Lob
	@Column(nullable = true)
	@Basic(fetch = FetchType.LAZY)
	@ElementCollection
	private List<byte[]> documentos = new ArrayList<>();
	
	public Problema(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setLink(List<Link> link) {
		this.link = link;
	}

	public void setFotos(List<byte[]> fotos) {
		this.fotos = fotos;
	}

	public void setVideos(List<byte[]> videos) {
		this.videos = videos;
	}

	public void setDocumentos(List<byte[]> documentos) {
		this.documentos = documentos;
	}
	
	
}
