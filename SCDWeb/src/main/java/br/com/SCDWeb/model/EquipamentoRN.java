package br.com.SCDWeb.model;

public class EquipamentoRN {

	public void salvar(Equipamento bm) {
			new EquipamentoDAO().inserir(bm);
	}
}
