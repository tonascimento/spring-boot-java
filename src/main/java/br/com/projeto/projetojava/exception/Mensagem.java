package br.com.projeto.projetojava.exception;

import java.io.Serializable;

public abstract class Mensagem implements Serializable {

	private static final long serialVersionUID = -7991432173022983984L;
	private String type;
    private String msg;

    public Mensagem() {
        super();
    }

    public Mensagem(String tipo, String msg) {
        this.type = tipo;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}