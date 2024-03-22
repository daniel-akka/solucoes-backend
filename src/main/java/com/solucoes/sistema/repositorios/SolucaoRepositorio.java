package com.solucoes.sistema.repositorios;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucoes.sistema.entidades.Solucao;

public interface SolucaoRepositorio extends JpaRepository<Solucao, UUID>{

}
