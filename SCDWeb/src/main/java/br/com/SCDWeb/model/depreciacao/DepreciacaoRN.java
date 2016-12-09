/**
 * 
 */
package br.com.SCDWeb.model.depreciacao;

import java.util.Calendar;
import java.util.Date;

import br.com.SCDWeb.model.equipamento.Equipamento;

/**
 * @author Lucas Keven C. de Souza
 *
 */
public class DepreciacaoRN {
	
	public Depreciacao calcularDepreciacao(Equipamento equipamento) {
		Depreciacao depreciacao = new Depreciacao();
		// Depreciação acumulada
	    Double da;
	    // custo do bem
		Double cb;
		// taxa
		Double i;
		// período
		int n = 0;
		// valor contábil
		Double vc;
		// Ganho ou perda
		Double gp;
		// valor residual
		Double vr = 0.0;
		Double turno = null;

		if (equipamento.getTurnoDeTrabalho() == 1)
			turno = 1.0;
		else if (equipamento.getTurnoDeTrabalho() == 2)
			turno = 1.5;
		else if (equipamento.getTurnoDeTrabalho() == 3)
			turno = 2.0;

		cb = equipamento.getValorDeCompra();
		i = (double) (equipamento.getDepreciacao() / 100) * turno;
		//n = calcularPeriodo(equipamento);
		vr = equipamento.getValorResidual();

		da = ((cb - vr) * i * n) / 12;

		vc = cb - da;

		gp = equipamento.getValorDeVenda() - vc;

		return depreciacao;
	}
	
	/*public int calcularPeriodo(Equipamento equipamento) {
		int periodo = 0;
		return periodo;
	}*/

	@SuppressWarnings("static-access")
	public int calcularPeriodo(Equipamento equipamento) {
		Calendar calInicial = Calendar.getInstance();
		Calendar calFinal = Calendar.getInstance();
		int periodo = 0;
		
		calInicial.setTime(equipamento.getDataDeCompra());
		calFinal.setTime(equipamento.getDataDeVenda());

		periodo = (calInicial.get(Calendar.YEAR) - calFinal.get(Calendar.YEAR)) * 12;

		// cálculo do ano inicial
		if (calInicial.DAY_OF_MONTH <= 15)
			periodo = periodo - (calInicial.MONTH - 1);
		else
			periodo = periodo - calInicial.MONTH;

		// cálculo do ano final
		if (calFinal.DAY_OF_MONTH <= 15)
			periodo = periodo + (calFinal.MONTH - 1);
		else
			periodo = periodo + calFinal.MONTH;

		return periodo;
	}
	
	public Calendar toCalendar(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal;
	}
}
