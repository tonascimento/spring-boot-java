package br.com.projeto.projetojava.service;

import static br.com.projeto.projetojava.exception.NegocioException.throwExceptionErroIfNull;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.projetojava.dominio.Pessoa;
import static br.com.projeto.projetojava.exception.NegocioException.*;
import br.com.projeto.projetojava.persistence.PessoaPersistence;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PessoaService {

	@Autowired
	private PessoaPersistence pessoaPersistence;

	public Pessoa salvarPessoa(Pessoa pessoa)  {
		throwExceptionErroIfNull(pessoa.getCpf(), "Necessário informar CPF da nova Pessoa");
		throwExceptionErroIfNull(pessoa.getNome(), "Necessário informar o nome da nova Pessoa");
		throwExceptionErroIfNull(pessoa.getDataNascimento(), "Necessário informar a data de nascimento da nova Pessoa");
		return pessoaPersistence.salvarPessoa(pessoa);
	}

	public void removerPessoa(Long idPessoa) {
		try {
		pessoaPersistence.removerPessoa(idPessoa);
		} catch (Exception e) {
			// necessário Loger
			throwExceptionErro("Erro na exclusão");
		}
	}
	
	public List<Pessoa> recuperarPessoas()  {
		return pessoaPersistence.recuperarPessoas();
	}

	public Pessoa recuperarPessoa(Long idPessoa) {
		 Pessoa pessoa = null;
			try {
				pessoa = pessoaPersistence.recuperarPessoa(idPessoa).get();
			} catch (NoSuchElementException e) {
				throwExceptionErroIfNull(pessoa, "Registro não encontrado");
			}
			return pessoa;
	}
}