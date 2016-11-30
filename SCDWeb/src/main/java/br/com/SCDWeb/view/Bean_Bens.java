package br.com.SCDWeb.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.SCDWeb.model.Bens;
import br.com.SCDWeb.model.BensRN;

@ManagedBean (name = "BeanBens")
public class Bean_Bens implements Serializable{

	private static final long serialVersionUID = 1L;

	private Bens bem = new Bens();

	public String actionGravar(){
		new BensRN().salvar(bem);
		return "";
	}
	
	public Bens getBm() {
		return bem;
	}

	public void setBm(Bens bem) {
		this.bem = bem;
	}
}
