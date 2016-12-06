package br.com.SCDWeb.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.SCDWeb.model.categoria.Categoria;
import br.com.SCDWeb.model.categoria.CategoriaRN;

/**
 * 
 * @author Leonardo
 *
 */

@ManagedBean (name = "viewCategoria")
@SessionScoped
public class CategoriaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Categoria categoria = new Categoria();
	
	public String actionAtualizar(){
		return "listagem_Categoria?faces-redirect=true";
	}
	
	public String actionApagar(){
		new CategoriaRN().apagar(categoria);
		return "listagem_Categoria?faces-redirect=true";
	}
	
	public List<Categoria> getTodasCategorias(){
		return new CategoriaRN().listarCategoria();
	}
	
	public String actionNovo(){
		this.setCategoria(new Categoria());
		return "listagem_Categoria?faces-redirect=true";
	}

	public String actionGravar(){
		new CategoriaRN().salvar(categoria);
		return "listagem_Categoria?faces-redirect=true";
		
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
