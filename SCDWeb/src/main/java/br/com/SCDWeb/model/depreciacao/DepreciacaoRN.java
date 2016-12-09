/**
 * 
 */
package br.com.SCDWeb.model.depreciacao;

import java.util.Calendar;

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
		Double anos;
		
		
		// definição do turno de trabalho
		// se turno = 1 multiplica-se a taxa por 1
		//			= 2							 1.5
		//			= 3							 2.0
		if (equipamento.getTurnoDeTrabalho() == 1)
			turno = 1.0;
		else if (equipamento.getTurnoDeTrabalho() == 2)
			turno = 1.5;
		else if (equipamento.getTurnoDeTrabalho() == 3)
			turno = 2.0;
		
		
		// levantamento das incógnitas
		cb = equipamento.getValorDeCompra();
		anos = (double) equipamento.getDepreciacao();
		i = (100 / anos) * turno;
		n = calcularPeriodo(equipamento);
		vr = equipamento.getValorResidual();
		vr = (vr/100) * cb;
		
		// fórmula da depreciação acumulada
		da = ((cb - vr) * (i/100) * n) / 12;
		
		// fórmula do valor contábil
		vc = cb - da;
		
		// fórmula do ganho ou perda
		gp = equipamento.getValorDeVenda() - vc;
		
		depreciacao.setDa(da);
		depreciacao.setGp(gp);
		depreciacao.setVc(vc);

		return depreciacao;
	}

	public int calcularPeriodo(Equipamento equipamento) {
		Calendar calInicial = Calendar.getInstance();
		Calendar calFinal = Calendar.getInstance();
		int periodo = 0;
		
		calInicial.setTime(equipamento.getDataDeCompra());
		calFinal.setTime(equipamento.getDataDeVenda());

		periodo = (calFinal.get(Calendar.YEAR) - calInicial.get(Calendar.YEAR)) * 12;

		// cálculo do ano inicial
		if (calInicial.get(Calendar.DAY_OF_MONTH) <= 15)
			periodo = periodo - (calInicial.get(Calendar.MONTH) - 1);
		else
			periodo = periodo - calInicial.get(Calendar.MONTH);

		// cálculo do ano final
		if (calFinal.get(Calendar.DAY_OF_MONTH) <= 15)
			periodo = periodo + (calFinal.get(Calendar.MONTH) - 1);
		else
			periodo = periodo + calFinal.get(Calendar.MONTH);

		return periodo;
	}
}
