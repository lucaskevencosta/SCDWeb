package br.com.SCDWeb.model.equipamento;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class EquipamentoRN {

	public void apagar(Equipamento equipamento){
		new EquipamentoDAO().delete(equipamento);
	}
	
	public List<Equipamento> listarTodos(){
		return new EquipamentoDAO().selectAll();
	}
	
	public void salvar(Equipamento equipamento){
		if (equipamento.getId() == null) {
			new EquipamentoDAO().inserir(equipamento);
		} else {
			new EquipamentoDAO().update(equipamento);
		}
	}
	
	public void calcularDepreciacao(Equipamento equipamento) {
		Double da;
		Double cb;
		Double i;
		int n;
		Double vc;
		Double gp;
		
		cb = equipamento.getValorDeCompra();
		i = (double) (equipamento.getDepreciacao() / 100);
		n = calcularPeriodo(equipamento);
		
		da = (cb * i * n) / 12;
		
		vc = cb - da;
		
		gp = equipamento.getValorDeVenda() - vc;
	}
	
	public int calcularPeriodo(Equipamento equipamento) {
		Date dtInicial = equipamento.getDataDeCompra();
		Date dtFinal = equipamento.getDataDeVenda();
		int periodo = 0;
		
		periodo = (encontrarAno(dtFinal) - encontrarAno(dtInicial) + 1) * 12;
		
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
