package br.com.projeto.projetojava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.projetojava.dominio.Pessoa;
import br.com.projeto.projetojava.service.PessoaService;

@SpringBootTest
class PessoaTests {

	private static final String CPF = "23451385496";
	
	@Autowired
	PessoaService pessoaService;
	
	@Test
	void criarPessoa() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(CPF);
		pessoa.setDataNascimento(LocalDateTime.now());
		pessoa.setNome("Pessoa 1");
		Pessoa pessoaSalva = pessoaService.salvarPessoa(pessoa);
		assertNotNull(pessoaSalva);
	}
	
	@Test
	void recuperarPessoas() throws Exception{
		List<Pessoa> pessoas = pessoaService.recuperarPessoas();
		assertNotNull(pessoas);
	}
	
	@Test
	void recuperarPessoa(){
		Pessoa pessoa = pessoaService.recuperarPessoa(1L);
		assertEquals(CPF, pessoa.getCpf());
		assertNotNull(pessoa);
	}
	
	@Test
	void removerPessoa(){
		pessoaService.removerPessoa(1L);
	}

}
