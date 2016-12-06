package br.com.SCDWeb.model.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.SCDWeb.util.ConnectionFactory;

/**
 * @author Leonardo
 *
 */

public class CategoriaDAO extends ConnectionFactory{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private Categoria cate = new Categoria();
	
	public void inserir(Categoria categoria){
		String sql = "INSERT INTO categorias(categoria, descricao) VALUES(?,?)";
		
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, categoria.getCategoria());
			ps.setString(2, categoria.getDescricao());
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
	
	public List<Categoria> selectAll(){
		List<Categoria> lsCategoria = null;
		String sql = "SELECT id, categoria, descricao FROM categorias ORDER BY id";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			lsCategoria = new ArrayList<Categoria>();
			while (rs.next()){
				Categoria cate = new Categoria();
				cate.setId(rs.getLong("id"));
				cate.setCategoria(rs.getString("categoria"));
				cate.setDescricao(rs.getString("descricao"));
				lsCategoria.add(cate);
			}
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return lsCategoria;
	}
	
	public void delete(Categoria categoria){
		String sql = "DELETE FROM categorias WHERE id = ?";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, categoria.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	
	public void update(Categoria categoria){
		String sql = "UPDATE categorias SET categoria = ?, descricao = ? WHERE id = ?";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, categoria.getCategoria());
			ps.setString(2, categoria.getDescricao());
			ps.setLong(3, categoria.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	
	public Categoria selectByID(Long id){
		Categoria categoria = null;
		String sql = "SELECT id, categoria, descricao FROM categorias WHERE id = ?";
		
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			categoria = new Categoria();
			if (rs.next()) {
				categoria.setId(rs.getLong("id"));
				categoria.setDescricao(rs.getString("categoria"));
				categoria.setDescricao(rs.getString("descricao"));
			}
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return categoria;
	}

	public Categoria getCate() {
		return cate;
	}

	public void setCate(Categoria cate) {
		this.cate = cate;
	}
}
















