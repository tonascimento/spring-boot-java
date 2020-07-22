package br.com.projeto.projetojava.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.projetojava.dominio.Pessoa;
import br.com.projeto.projetojava.exception.NegocioException;
import br.com.projeto.projetojava.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/pessoa")
    @ApiOperation("Salvar nova Pessoa")
	private ResponseEntity<?> criarPessoa(@ApiParam("Dados de Pessoa")@RequestBody Pessoa pessoa) {
		try {
			return ResponseEntity.ok( pessoaService.salvarPessoa(pessoa));
		} catch (NegocioException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessages().get(0));
		}
	}
	
	@DeleteMapping("/pessoa/excluir")
    @ApiOperation("Excluir uma Pessoa")
	private ResponseEntity<?> removerPessoa(@ApiParam(value = "idPessoa") @RequestBody Long idPessoa) {
		try {
			pessoaService.removerPessoa(idPessoa);
			return (ResponseEntity<?>) ResponseEntity.ok();
		} catch (NegocioException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessages().get(0));
		}
	}
	
	@GetMapping("/pessoas")
    @ApiOperation("Recuperar Pessoas")
	public List<Pessoa> recuperarPessoas() {
		return pessoaService.recuperarPessoas();		
	}
	
	@GetMapping("/pessoa/{idPessoa}")
    @ApiOperation("Recuperar Pessoa")
	public ResponseEntity<?> recuperarPessoa(@ApiParam(value = "idPessoa") @PathVariable("idPessoa") Long idPessoa) {
		try {
			return ResponseEntity.ok(pessoaService.recuperarPessoa(idPessoa));
		} catch (NegocioException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessages().get(0));
		}
	}

}