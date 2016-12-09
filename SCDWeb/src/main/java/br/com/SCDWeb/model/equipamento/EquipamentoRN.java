package br.com.SCDWeb.model.equipamento;

import java.util.List;


public class EquipamentoRN {

	public void apagar(Equipamento equipamento){
		new EquipamentoDAO().delete(equipamento);
	}
	
	public List<Equipamento> listarTodos(){
		return new EquipamentoDAO().selectAll();
	}
	
	public List<Equipamento> listaCalc(){
		return new EquipamentoDAO().selectCalc();
	}
	
	public void salvar(Equipamento equipamento){
		if (equipamento.getId() == null) {
			new EquipamentoDAO().inserir(equipamento);
		} else {
			new EquipamentoDAO().update(equipamento);
		}
	}
}
