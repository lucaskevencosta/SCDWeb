package br.com.SCDWeb.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.SCDWeb.util.ConnectionFactory;

public class BensDAO extends ConnectionFactory{

	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	private Bens bem = new Bens();

	public void inserir(Bens bm){
		String sql = "INSERT INTO cadastro(referencia, produto, data_de_compra, data_de_venda, valor_de_compra, valor_de_venda, turno_de_trabalho, tipo_de_produto, depreciacao) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bm.getReferenciaProduto());
			ps.setString(2, bm.getProduto());
			ps.setDate(3, new Date(bm.getData_de_compra().getTime()));
			ps.setDate(4, new Date(bm.getData_de_venda().getTime()));
			ps.setDouble(5, bm.getValor_da_compra());
			ps.setDouble(6, bm.getValor_da_venda());
			ps.setInt(7, bm.getTurno_de_trabalho());
			ps.setString(8, bm.getTipo_de_produto());
			ps.setInt(9, bm.getAnos_depreciacao());

			ps.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	
	
	public Bens getBem() {
		return bem;
	}

	public void setBem(Bens bem) {
		this.bem = bem;
	}
}
