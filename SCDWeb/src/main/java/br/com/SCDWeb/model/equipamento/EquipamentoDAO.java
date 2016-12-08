package br.com.SCDWeb.model.equipamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.SCDWeb.model.categoria.CategoriaRN;
import br.com.SCDWeb.util.ConnectionFactory;

/**
 * 
 * @author Leonardo
 *
 */

public class EquipamentoDAO extends ConnectionFactory {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public void inserir(Equipamento equipamento) {
		String sql = "INSERT INTO equipamento(REFERENCIA, PRODUTO, DATA_DE_COMPRA, DATA_DE_VENDA, VALOR_DE_COMPRA, VALOR_DE_VENDA, TURNO_DE_TRABALHO, ESTADO_DO_PRODUTO, DEPRECIACAO, CATEGORIA) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, equipamento.getReferencia());
			ps.setString(2, equipamento.getProduto());
			ps.setDate(3, new Date(equipamento.getDataDeCompra().getTime()));
			if (equipamento.getDataDeVenda() != null) {
				java.sql.Date d = new java.sql.Date(equipamento.getDataDeVenda().getTime());
				ps.setDate(4, d);
			} else {
				ps.setNull(4, Types.DATE);
			}
			ps.setDouble(5, equipamento.getValorDeCompra());
			ps.setDouble(6, equipamento.getValorDeVenda());
			ps.setInt(7, equipamento.getTurnoDeTrabalho());
			ps.setString(8, equipamento.getEstadoDoProduto());
			ps.setInt(9, equipamento.getDepreciacao());
			ps.setLong(10, equipamento.getCategoria().getId());
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

	public List<Equipamento> selectAll() {
		List<Equipamento> lsEquipamento = null;
		String sql = "SELECT ID, REFERENCIA, PRODUTO, DATA_DE_COMPRA, DATA_DE_VENDA, VALOR_DE_COMPRA, VALOR_DE_VENDA, TURNO_DE_TRABALHO, ESTADO_DO_PRODUTO, DEPRECIACAO, CATEGORIA FROM equipamento ORDER BY id";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			lsEquipamento = new ArrayList<>();
			while (rs.next()) {
				Equipamento eqp = new Equipamento();
				eqp.setId(rs.getLong("ID"));
				eqp.setReferencia(rs.getInt("REFERENCIA"));
				eqp.setProduto(rs.getString("PRODUTO"));
				eqp.setDataDeCompra(rs.getDate("DATA_DE_COMPRA"));
				eqp.setDataDeVenda(rs.getDate("DATA_DE_VENDA"));
				eqp.setValorDeCompra(rs.getDouble("VALOR_DE_COMPRA"));
				eqp.setValorDeVenda(rs.getDouble("VALOR_DE_VENDA"));
				eqp.setTurnoDeTrabalho(rs.getInt("TURNO_DE_TRABALHO"));
				eqp.setEstadoDoProduto(rs.getString("ESTADO_DO_PRODUTO"));
				eqp.setDepreciacao(rs.getInt("DEPRECIACAO"));
				eqp.setCategoria(new CategoriaRN().listarPorId(rs.getLong("CATEGORIA")));
				lsEquipamento.add(eqp);
			}
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return lsEquipamento;
	}

	public void delete(Equipamento equipamento) {
		String sql = "DELETE FROM equipamento WHERE id = ?";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, equipamento.getId());
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

	public void update(Equipamento equipamento) {
		String sql = "UPDATE equipamento SET PRODUTO = ?, DATA_DE_COMPRA = ?, DATA_DE_VENDA = ?, VALOR_DE_COMPRA =  ?, VALOR_DE_VENDA = ?, TURNO_DE_TRABALHO = ?, ESTADO_DO_PRODUTO = ?, DEPRECIACAO  = ?, CATEGORIA =  ? WHERE ID = ?";

		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, equipamento.getProduto());
			ps.setDate(2, new Date(equipamento.getDataDeCompra().getTime()));
			ps.setDate(3, new Date(equipamento.getDataDeCompra().getTime()));
			if (equipamento.getDataDeVenda() != null) {
				java.sql.Date d = new java.sql.Date(equipamento.getDataDeVenda().getTime());
				ps.setDate(3, d);
			} else {
				ps.setNull(3, Types.DATE);
			}
			ps.setDouble(4, equipamento.getValorDeCompra());
			ps.setDouble(5, equipamento.getValorDeVenda());
			ps.setInt(6, equipamento.getTurnoDeTrabalho());
			ps.setString(7, equipamento.getEstadoDoProduto());
			ps.setInt(8, equipamento.getDepreciacao());
			ps.setLong(9, equipamento.getCategoria().getId());
			ps.setLong(10, equipamento.getId());
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
