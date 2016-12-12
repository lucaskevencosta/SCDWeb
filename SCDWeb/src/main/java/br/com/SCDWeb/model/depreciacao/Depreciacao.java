/**
 * 
 */
package br.com.SCDWeb.model.depreciacao;

import java.io.Serializable;

/**
 * @author Lucas Keven C. de Souza
 *
 */
public class Depreciacao implements Serializable {
	
	@Override
	public String toString() {
		return "Depreciacao [da=" + da + ", vc=" + vc + ", gp=" + gp + "]";
	}

	private static final long serialVersionUID = 1L;
	// depreciação acumulada
	private Double da;
	// valor contábil
	private Double vc;
	// ganho ou perda
	private Double gp;
	
	public Double getDa() {
		return da;
	}
	
	public void setDa(Double da) {
		this.da = da;
	}
	
	public Double getVc() {
		return vc;
	}
	
	public void setVc(Double vc) {
		this.vc = vc;
	}
	
	public Double getGp() {
		return gp;
	}
	
	public void setGp(Double gp) {
		this.gp = gp;
	}
	
	
}
