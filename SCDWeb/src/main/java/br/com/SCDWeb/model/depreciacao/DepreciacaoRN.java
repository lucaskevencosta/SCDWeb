/**
 * 
 */
package br.com.SCDWeb.model.depreciacao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
		int n;
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
		n = calcularPeriodo(equipamento);
		vr = equipamento.getValorResidual();

		da = ((cb - vr) * i * n) / 12;

		vc = cb - da;

		gp = equipamento.getValorDeVenda() - vc;

		return depreciacao;
	}

	public int calcularPeriodo(Equipamento equipamento) {
		GregorianCalendar gcInicial = new GregorianCalendar();
		GregorianCalendar gcFinal = new GregorianCalendar();
		int periodo = 0;
		
		gcInicial.setTime(equipamento.getDataDeCompra());
		gcFinal.setTime(equipamento.getDataDeVenda());

		periodo = (gcInicial.YEAR - gcFinal.YEAR) * 12;

		// cálculo do ano inicial
		if (gcInicial.DAY_OF_MONTH <= 15)
			periodo = periodo - (gcInicial.MONTH - 1);
		else
			periodo = periodo - gcInicial.MONTH;

		// cálculo do ano final
		if (gcFinal.DAY_OF_MONTH <= 15)
			periodo = periodo + (gcFinal.MONTH - 1);
		else
			periodo = periodo + gcFinal.MONTH;

		return periodo;
	}
}
