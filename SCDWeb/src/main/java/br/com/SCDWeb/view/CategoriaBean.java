package br.com.SCDWeb.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.SCDWeb.model.categoria.Categoria;
import br.com.SCDWeb.model.categoria.CategoriaRN;

/**
 * 
 * @author Leonardo
 *
 */

@ManagedBean (name = "viewCategoria")
public class CategoriaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Categoria categoria = new Categoria();


	public String actionAtualizar(){
		return "listagem_categoria";
	}
	
	public String actionApagar(){
		new CategoriaRN().apagar(categoria);
		return "listagem_categoria?faces-redirect=true";
	}
	
	public List<Categoria> getTodasCategorias(){
		return new CategoriaRN().listarCategoria();
	}
	
	public String actionGravar(){
		new CategoriaRN().salvar(categoria);
		return "listagem_categoria?faces-redirect=true";
		
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
