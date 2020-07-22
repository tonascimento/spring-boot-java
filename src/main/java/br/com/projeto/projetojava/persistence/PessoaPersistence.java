package br.com.projeto.projetojava.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.projetojava.dominio.Pessoa;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PessoaPersistence  {

	
	@Autowired
	private IPessoaPersistence pessoaPersistence;

	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaPersistence.save(pessoa);
	}

	public void removerPessoa(Long idPessoa) {
		pessoaPersistence.deleteById(idPessoa);
	}
	
	public List<Pessoa> recuperarPessoas(){
		return pessoaPersistence.findAll();
	}

	public Optional<Pessoa> recuperarPessoa(Long idPessoa) {
		return pessoaPersistence.findById(idPessoa);
	}
}