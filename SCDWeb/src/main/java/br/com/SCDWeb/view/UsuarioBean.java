/**
 * 
 */
package br.com.SCDWeb.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.SCDWeb.model.usuario.UsuarioRN;

/**
 * @author user
 *
 */

@SessionScoped
@ManagedBean(name = "viewUsuario")
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuarioEntrada;
	private String senhaEntrada;
	private String error;

	public String actionLogar() {
		if (new UsuarioRN().validaLogin(usuarioEntrada, senhaEntrada))
			return "boas_Vinda.xhtml";
		else {
			// Cria uma mensagem
			FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
			// Obtém a instância atual do FacesContext e adiciona a mensagem de erro nele
			FacesContext.getCurrentInstance().addMessage("erro", msg);
			return null;
		}
	}

	public String getUsuarioEntrada() {
		return usuarioEntrada;
	}

	public void setUsuarioEntrada(String usuarioEntrada) {
		this.usuarioEntrada = usuarioEntrada;
	}

	public String getSenhaEntrada() {
		return senhaEntrada;
	}

	public void setSenhaEntrada(String senhaEntrada) {
		this.senhaEntrada = senhaEntrada;
	}

	public String getError() {
		return error;
	}

}
