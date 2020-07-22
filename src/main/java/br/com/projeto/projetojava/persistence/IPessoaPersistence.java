package br.com.projeto.projetojava.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.projetojava.dominio.Pessoa;

@Repository
public interface IPessoaPersistence extends JpaRepository<Pessoa, Long> {
	
	
}