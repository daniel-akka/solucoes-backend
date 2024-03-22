package com.solucoes.sistema.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solucoes.sistema.entidades.RecoveryPassword;

public interface RecoveryPasswordRepositorio extends JpaRepository<RecoveryPassword, UUID> {

	@Query("SELECT EXISTS(SELECT p.a_confirmar FROM RecoveryPassword p WHERE " 
			+ "p.email = :email AND p.a_confirmar = true)")
	public boolean existRecoveryPendente(@Param("email") String email);
}
