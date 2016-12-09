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
	private Depreciacao depreciacao = new Depreciacao();
	
	public Depreciacao getDepreciacao() {
		return depreciacao;
	}
	
	public void setDepreciacao(Depreciacao depreciacao) {
		this.depreciacao = depreciacao;
	}
	
	public void calcularDepreciacao(Equipamento equipamento) {
		depreciacao = new DepreciacaoRN().calcularDepreciacao(equipamento);
	}
}
