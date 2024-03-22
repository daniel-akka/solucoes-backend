package com.solucoes.sistema.recursos;

/*import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.solucoes.sistema.dtos.PermissaoGeralDTO;
import com.solucoes.sistema.entidades.PermissaoGeral;
import com.solucoes.sistema.servicos.PermissaoGeralServico;
import jakarta.validation.Valid;*/

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paginas.permissao_geral)
public class PermissaoGeralRecurso {

	/*@Autowired
	private PermissaoGeralServico servico;
	
	@PostMapping
	public PermissaoGeral save(@Valid @RequestBody PermissaoGeralDTO dto) {
		PermissaoGeral permissao = new PermissaoGeral();
		BeanUtils.copyProperties(dto, permissao);
		return servico.salvar(permissao);
	}
	
	@GetMapping
	public ResponseEntity<List<PermissaoGeral>> todos(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.buscaTodos());
	}*/
}
