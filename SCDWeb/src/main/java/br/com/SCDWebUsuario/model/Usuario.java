package br.com.SCDWebUsuario.model;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
	private String msgErro;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMsgErro() {
		return msgErro;
	}
	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
}
