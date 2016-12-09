/**
 * 
 */
package br.com.SCDWeb.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.SCDWeb.model.depreciacao.Depreciacao;
import br.com.SCDWeb.model.depreciacao.DepreciacaoRN;
import br.com.SCDWeb.model.equipamento.Equipamento;

/**
 * @author Lucas Keven C. de Souza
 *
 */

@SessionScoped
@ManagedBean (name="viewDepreciacao")
public class DepreciacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Depreciacao depreciacao = new Depreciacao();
	Equipamento equipamento = new Equipamento();
	
	
	public void prepararCalculo(Equipamento equipamento) {
		setEquipamento(equipamento);
		//this.depreciacao = new DepreciacaoRN().calcularDepreciacao(equipamento);
	}
	
	public Depreciacao getDepreciacao() {
		return depreciacao;
	}
	public void setDepreciacao(Depreciacao depreciacao) {
		this.depreciacao = depreciacao;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
}
