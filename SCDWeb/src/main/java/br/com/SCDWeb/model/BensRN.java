package br.com.SCDWeb.model;

public class BensRN {

	public void salvar(Bens bm) {
		
			new BensDAO().inserir(bm);
	}
}
