package br.com.SCDWeb.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.SCDWeb.model.Bens;
import br.com.SCDWeb.model.BensRN;
import br.com.SCDWebUsuario.model.Usuario;

@ManagedBean (name = "BeanBens")
public class Bean_Bens implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario user = new Usuario();
	private Bens bem = new Bens();

	public String actionGravar(){
		new BensRN().salvar(bem);
		return "";
	}
	
	public String actionLogar(){
		String irPara = "index";
		if (user.getUsuario().equals("admin") && user.getSenha().equals("admin")){
			irPara = "boas_Vinda";
		} else {
			user.setMsgErro("Usuario ou Senha Inválidos");
		}
		return irPara;
	}
	
	public Bens getBm() {
		return bem;
	}

	public void setBm(Bens bem) {
		this.bem = bem;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
}
