package br.com.SCDWeb.model.equipamento;

import java.util.List;


public class EquipamentoRN {

	public void apagar(Equipamento equipamento){
		new EquipamentoDAO().delete(equipamento);
	}
	
	public List<Equipamento> listarTodos(){
		return new EquipamentoDAO().selectAll();
	}
	
	public Equipamento listarPorId (Long id) {
		return new EquipamentoDAO().selectById(id);
	}
	
	public void salvar(Equipamento equipamento){
		if (equipamento.getId() == null) {
			new EquipamentoDAO().inserir(equipamento);
		} else {
			new EquipamentoDAO().update(equipamento);
		}
	}
}
