package br.com.projeto.projetojava.exception;

public class MensagemErro extends Mensagem {

	private static final long serialVersionUID = -7821399999661963961L;

	public MensagemErro(String conteudo) {
        super("error", conteudo);
    }
}