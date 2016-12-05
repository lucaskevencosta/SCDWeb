package br.com.SCDWeb.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.SCDWeb.model.Equipamento;
import br.com.SCDWeb.model.EquipamentoRN;
import br.com.SCDWebUsuario.model.Usuario;

@ManagedBean (name = "BeanBens")
public class EquipamentoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario user = new Usuario();
	private Equipamento bem = new Equipamento();

	public String actionGravar(){
		new EquipamentoRN().salvar(bem);
		return "";
	}
	
	public String actionLogin(){
		String irPara = "index";
		if (user.getUsuario().equals("admin") && user.getSenha().equals("admin")){
			irPara = "boas_Vinda";
		} else {
			user.setMsgErro("Usuario ou Senha Inválidos");
		}
		return irPara;
	}
	
	public Equipamento getBm() {
		return bem;
	}

	public void setBm(Equipamento bem) {
		this.bem = bem;
	}



	public Usuario getUser() {
		return user;
	}



	public void setUser(Usuario user) {
		this.user = user;
	}
}
