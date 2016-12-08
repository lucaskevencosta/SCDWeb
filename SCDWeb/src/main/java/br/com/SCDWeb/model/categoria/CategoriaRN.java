package br.com.SCDWeb.model.categoria;

import java.util.List;

/**
 * @author Leonardo
 *
 */

public class CategoriaRN {

	public void salvar(Categoria categoria){
		new CategoriaDAO().salvar(categoria);
	}
	
	public List<Categoria> listarCategoria(){
		return new CategoriaDAO().selectAll();
	}
	
	public List<Categoria> listarTodasCategoria(){
		return new CategoriaDAO().selectAll();
	}
	
	public void apagar(Categoria categoria){
			new CategoriaDAO().delete(categoria);
	}
	
	public Categoria listarPorId(Long id){
		return new CategoriaDAO().selectByID(id);
	}
}
