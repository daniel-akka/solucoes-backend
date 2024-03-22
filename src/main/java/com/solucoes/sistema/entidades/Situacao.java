package com.solucoes.sistema.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import com.solucoes.sistema.dtos.crud.SituacaoRecordDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Component
@Entity
public class Situacao extends RepresentationModel<Situacao> 
	implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private String resumo;

	@OneToOne(mappedBy = "situacao", optional = false, fetch = FetchType.LAZY,  
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Problema problema;
	
	@OneToMany(mappedBy = Solucao_.SITUACAO)
	private List<Solucao> solucoes = new ArrayList<>();
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_fk", referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "situacao")
	private List<PermissaoSituacao> permissoes_situacao = new ArrayList<>();

	public Situacao(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}

	public void setSolucoes(List<Solucao> solucoes) {
		this.solucoes = solucoes;
	}

	public void setPermissoes_situacao(List<PermissaoSituacao> permissoes_situacao) {
		this.permissoes_situacao = permissoes_situacao;
	}
	
	public Situacao criarSituacao(SituacaoRecordDto situacaoRecord, Usuario usuario) {

		this.problema = new Problema(this);
		this.usuario = usuario;
		this.problema.setDescricao(situacaoRecord.problema_descricao());
		this.problema.setLink(situacaoRecord.problema_links());
		
		this.setResumo(situacaoRecord.situacao_resumo());
		this.setProblema(problema);
		
		return this;
	}
	
	public Situacao updateSituacao(SituacaoRecordDto situacaoRecord) {

		this.problema.setDescricao(situacaoRecord.problema_descricao());
		this.problema.setLink(situacaoRecord.problema_links());		
		this.setResumo(situacaoRecord.situacao_resumo());
		
		return this;
	}
}
