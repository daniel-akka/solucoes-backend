package com.solucoes.sistema.recursos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solucoes.sistema.dtos.consulta.SituacaoRecordPesquisa;
import com.solucoes.sistema.dtos.crud.SituacaoDTO;
import com.solucoes.sistema.dtos.crud.SituacaoRecordDto;
import com.solucoes.sistema.entidades.Situacao;
import com.solucoes.sistema.servicos.SituacaoServico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("Situacao")
public class SituacaoRecurso {

	@Autowired
	private SituacaoServico servico;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid SituacaoRecordDto dto) {
		
		
		try {
			
			Situacao situacao = servico.criarSituacao(dto);
			
			if (situacao instanceof Situacao) {
				
				try {
					
					servico.salvar(situacao);
					return ResponseEntity.status(HttpStatus.CREATED).body("OK");
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
				}
				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
			}
			
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
	
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody @Valid SituacaoRecordDto dto, 
			@RequestParam @NotBlank UUID id_situacao) {
		
		
		try {
			
			
			Situacao updateSituacao = servico.situacaoAlterada(id_situacao, dto);
			
			boolean podeAtualizar = (updateSituacao instanceof Situacao);
		
			if (podeAtualizar) {
				
				
				try {
					
					servico.salvar(updateSituacao);
					return ResponseEntity.status(HttpStatus.CREATED).body("OK");
				} catch (Exception e) {
					// TODO: handle exception
				}return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
				
				
			}else {
				
				//Se não for possivel atualizar...
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
			}
			
		}catch(Exception e){
			
			//Se ocorrer erro ao converter o idString passado como parametro para o tipo UUID
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
	
	@GetMapping
	public ResponseEntity<List<SituacaoRecordPesquisa>> todos(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.buscaTodosQuerySimples());
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getSituacao(@RequestParam @Valid @NotBlank UUID id_situacao){
		SituacaoDTO situacao = servico.situacaoDtoPorID(id_situacao);
		
		if (situacao == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Situação não encontrada!");
		}

		
		return ResponseEntity.status(HttpStatus.OK).body(situacao);
	}
	
	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestParam @NotBlank UUID id_situacao) {
		
		
		try {
			
			servico.deletar(id_situacao);
			return ResponseEntity.status(HttpStatus.OK).body("OK");
			
		}catch(Exception e){
			
			//Se ocorrer erro ao converter o idString passado como parametro para o tipo UUID
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("ERRO");
		}
	}
	
}
