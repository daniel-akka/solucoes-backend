package com.solucoes.sistema.repositorios;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solucoes.sistema.dtos.consulta.SituacaoRecordPesquisa;
import com.solucoes.sistema.entidades.Situacao;
import com.solucoes.sistema.entidades.Usuario;

public interface SituacaoRepositorio extends JpaRepository<Situacao, UUID>{

	
	@Query("SELECT new com.solucoes.sistema.dtos.consulta.SituacaoRecordPesquisa"
			+ "(s.id, s.resumo, s.problema.descricao) FROM Situacao s")
	List<SituacaoRecordPesquisa> findAllSimple();
	
	@Query("SELECT new com.solucoes.sistema.dtos.consulta.SituacaoRecordPesquisa"
			+ "(s.id, s.resumo, s.problema.descricao) FROM Situacao s WHERE s.usuario = :usuario")
	List<SituacaoRecordPesquisa> situacoesPorUsuario(@Param("usuario") Usuario u);
	
	@Query("SELECT new com.solucoes.sistema.dtos.consulta.SituacaoRecordPesquisa"
			+ "(s.id, s.resumo, s.problema.descricao) FROM Situacao s WHERE s.usuario.id = :idusuario")
	List<SituacaoRecordPesquisa> situacoesPorIdUsuario(@Param("idusuario") String u);
	
	
	/*@Query("SELECT new com.solucoes.sistema.dtos.crud.SituacaoRecord"
			+ "(s.id, s.usuario.id AS id_usuario, s.resumo AS situacao_resumo, " 
			+ "s.problema.id AS problema_id, s.problema.descricao AS problema_descricao"
			+ ") FROM Situacao s WHERE s.id = :id")
	SituacaoRecord situacaoDtoPorID(@Param("id") UUID u);*/
	
	
}
