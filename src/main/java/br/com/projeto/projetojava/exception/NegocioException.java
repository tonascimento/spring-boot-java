package br.com.projeto.projetojava.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient List<Mensagem> mensagens = new ArrayList<>();

    public NegocioException(String... messages) {
        for (String mensagem : Arrays.asList(messages)) {
            this.mensagens.add(new MensagemErro(mensagem));
        }
    }

    public NegocioException(Mensagem... messages) {
        this.mensagens.addAll(Arrays.asList(messages));
    }

    public NegocioException() {
    }

    public void add(Mensagem message) {
        this.mensagens.add(message);
    }

    public List<Mensagem> getMessages() {
        return mensagens;
    }

    public static void throwExceptionErro(String mensagem) {
        throw new NegocioException(new MensagemErro(mensagem));
    }

    public static <T> void throwExceptionErroIfNull(T objeto, String mensagem) {
        if (objeto == null) {
            throwExceptionErro(mensagem);
        }
    }
}