package com.solucoes.sistema.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solucoes.sistema.dtos.consulta.SituacaoRecordPesquisa;
import com.solucoes.sistema.dtos.crud.SituacaoDTO;
import com.solucoes.sistema.dtos.crud.SituacaoRecordDto;
import com.solucoes.sistema.entidades.Situacao;
import com.solucoes.sistema.entidades.Usuario;
import com.solucoes.sistema.repositorios.SituacaoRepositorio;
import com.solucoes.sistema.repositorios.UsuarioRepositorio;

@Service
public class SituacaoServico {

	@Autowired
	private SituacaoRepositorio repo;
	
	@Autowired
	private UsuarioRepositorio usu_repo;
	
	
	public Situacao salvar(Situacao situacao) {
		repo.save(situacao);
		return situacao;
	}
	
	public Situacao criarSituacao(SituacaoRecordDto situacaoRecord) {
		
		if (!situacaoRecord.id_usuario().isEmpty()) {
			
			UUID idUsuario  = UUID.fromString(situacaoRecord.id_usuario());
			Optional<Usuario> usuario = this.usu_repo.findById(idUsuario);
			
			if (!usuario.isEmpty()) {
				
				Situacao situacao = new Situacao()
						.criarSituacao(situacaoRecord, usuario.get());
				
				return situacao;
				
			}else {return null;}
		}
		
		
		return null;
	}
	
	public Situacao situacaoAlterada(UUID id_situacao, SituacaoRecordDto situacaoRecord) {
		
		Situacao situacao = this.buscarPorID(id_situacao);
		
		if (situacao instanceof Situacao) {
			
			situacao.updateSituacao(situacaoRecord);
			
			return situacao;
		}
		
		
		return null;
	}
	

	public void deletar(UUID id) {
		repo.deleteById(id);
	}
	
	public void deletar(Situacao situacao) {
		repo.delete(situacao);
	}
	
	
	public List<Situacao> buscaTodos(){
		return repo.findAll();
	}
	
	public List<SituacaoRecordPesquisa> buscaTodosQuerySimples(){
		return repo.findAllSimple();
	}
	
	public List<SituacaoDTO> buscaTodosDTOs(){
		return this.dtos(repo.findAll());
	}
	
	public Situacao buscarPorID(UUID id) {
		Optional<Situacao> opt = repo.findById(id);
		return opt.get();
	}
	
	public SituacaoDTO situacaoDtoPorID(UUID id) {
		
		Optional<Situacao> opt = repo.findById(id);
		
		if (opt.isEmpty()) {
			return null;
		}
		
		Situacao situacao = opt.get();
		SituacaoDTO dto = new SituacaoDTO(situacao);
		
		return dto;
	}

	public List<SituacaoRecordPesquisa> situacoesPorUsuario(Usuario u){
		return repo.situacoesPorUsuario(u);
	}
	
	public List<SituacaoRecordPesquisa> situacoesPorIdUsuario(String id){
		return repo.situacoesPorIdUsuario(id);
	}
	
	private List<SituacaoDTO> dtos(List<Situacao> situacoes){
		
		List<SituacaoDTO> dtos = new ArrayList<>();
		situacoes.forEach(s -> dtos.add(new SituacaoDTO(s)));
		
		return dtos;
	}
}
