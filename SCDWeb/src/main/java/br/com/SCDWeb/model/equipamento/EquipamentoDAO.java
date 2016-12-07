package br.com.SCDWeb.model.equipamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.SCDWeb.util.ConnectionFactory;

public class EquipamentoDAO extends ConnectionFactory{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public void inserir(Equipamento equipamento){
		String sql = "INSERT INTO equipamento(referencia, produto, data_de_compra, data_de_venda, valor_de_compra, valor_de_compra, turno_de_trabalho, depreciacao, categoria) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, equipamento.getReferencia());
			ps.setString(2, equipamento.getProduto());
			ps.setDate(3, new Date(equipamento.getDataDeCompra().getTime()));
			ps.setDate(4, new Date(equipamento.getDataDeVenda().getTime()));
			ps.setDouble(5, equipamento.getValorDeCompra());
			ps.setDouble(6, equipamento.getValorDeVenda());
			ps.setDouble(7, equipamento.getValorDeCompra());
			ps.setInt(8, equipamento.getDepreciacao());
			ps.setLong(9, equipamento.getCategoria().getId());
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
}
