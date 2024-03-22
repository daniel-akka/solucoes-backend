package com.solucoes.sistema.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucoes.sistema.entidades.PermissaoGeral;

public interface PermissaoGeralRepositorio extends JpaRepository<PermissaoGeral, UUID>{

}
