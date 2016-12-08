/**
 * 
 */
package br.com.SCDWeb.model.depreciacao;

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
		Double da;
		Double cb;
		Double i;
		int n;
		Double vc;
		Double gp;
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

		da = (cb * i * n) / 12;

		vc = cb - da;

		gp = equipamento.getValorDeVenda() - vc;

		return depreciacao;
	}

	public int calcularPeriodo(Equipamento equipamento) {
		Date dtInicial = equipamento.getDataDeCompra();
		Date dtFinal = equipamento.getDataDeVenda();
		int periodo = 0;

		periodo = (encontrarAno(dtFinal) - encontrarAno(dtInicial)) * 12;

		// cálculo do ano inicial
		if (encontrarDiaDoMes(dtInicial) <= 15)
			periodo = periodo - (encontrarMes(dtInicial) - 1);
		else
			periodo = periodo - encontrarMes(dtInicial);

		// cálculo do ano final
		if (encontrarDiaDoMes(dtFinal) <= 15)
			periodo = periodo + (encontrarMes(dtFinal) - 1);
		else
			periodo = periodo + (encontrarMes(dtFinal));

		return periodo;
	}

	public int encontrarDiaDoMes(Date dt) {

		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(dt);
		int dia = calendario.get(GregorianCalendar.DAY_OF_MONTH);

		return dia;
	}

	public int encontrarMes(Date dt) {

		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(dt);
		int mes = calendario.get(GregorianCalendar.MONTH);

		return mes;
	}

	public int encontrarAno(Date dt) {

		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(dt);
		int ano = calendario.get(GregorianCalendar.YEAR);

		return ano;
	}
}
