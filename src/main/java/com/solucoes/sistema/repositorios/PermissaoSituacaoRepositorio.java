package com.solucoes.sistema.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucoes.sistema.entidades.PermissaoSituacao;

public interface PermissaoSituacaoRepositorio extends JpaRepository<PermissaoSituacao, UUID>{

}
