/**
 * 
 */
package br.com.SCDWeb.model.usuario;

import java.io.Serializable;

/**
 * @author Lucas Keven C. de Souza
 *
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String USUARIO = "admin";
	private final String SENHA = "admin";
	
	public String getUSUARIO() {
		return USUARIO;
	}
	
	public String getSENHA() {
		return SENHA;
	}

}
