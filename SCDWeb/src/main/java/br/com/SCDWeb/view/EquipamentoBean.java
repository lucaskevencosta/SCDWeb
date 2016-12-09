package br.com.SCDWeb.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.SCDWeb.model.categoria.Categoria;
import br.com.SCDWeb.model.categoria.CategoriaRN;
import br.com.SCDWeb.model.equipamento.Equipamento;
import br.com.SCDWeb.model.equipamento.EquipamentoRN;

/**
 * 
 * @author Leonardo
 *
 */

@ManagedBean (name = "viewEquipamento")
@SessionScoped
public class EquipamentoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Equipamento equipamento = new Equipamento();
	
	public String actionAtualizar(){
		return "cadastro_equipamento";
	}
	
	public String actionCalcular() {
		new DepreciacaoBean().calcularDepreciacao(equipamento);
		return "relatorio_depreciacao";
	}
	
	public String actionApagar(){
		new EquipamentoRN().apagar(equipamento);
		return "listagem_equipamento?faces-redirect=true";
	}
	
	public String actionChamarCalculo(){
		return "formulario_depreciacao";
	}

	public List<Categoria> getTodasCategorias(){
		return new CategoriaRN().listarCategoria();
	}
	
	public List<Equipamento> getTodosEquipamentos(){
		return new EquipamentoRN().listarTodos();
	}
	
	public String actionSalvar(){
		new EquipamentoRN().salvar(equipamento);
		return "listagem_equipamento?faces-redirect=true";
	}
	
	public String actionNovo(){
		this.equipamento = new Equipamento();
		return "cadastro_equipamento";
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public String actionInicio() {
		return "listagem_equipamento?faces-redirect=true";
	}
}
