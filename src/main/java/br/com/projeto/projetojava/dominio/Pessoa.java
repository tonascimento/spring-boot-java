package br.com.projeto.projetojava.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 6795405604348579866L;

	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 250)
	private String nome;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "data_nascimento", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}