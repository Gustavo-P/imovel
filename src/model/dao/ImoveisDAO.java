package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Imoveis;

public class ImoveisDAO {

	public void create(Imoveis i) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con
					.prepareStatement("INSERT INTO IMOVEIS (endereco, nbairro, cidade, cep, locavenda, valor) VALUES"
							+ "(?,?,?,?,?,?)");
			
			stmt.setString(1, i.getEndereco());
			stmt.setString(2, i.getNbairro());
			stmt.setString(3, i.getCidade());
			stmt.setString(4, i.getCep());
			stmt.setBoolean(5, i.isLocavenda());
			stmt.setString(6, i.getValor());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Imóvel Salvo com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public List<Imoveis> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Imoveis> imovel = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM imoveis;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Imoveis i = new Imoveis();
				i.setIdImovel(rs.getInt("idImovel"));
				i.setEndereco(rs.getString("endereco"));
				i.setNbairro(rs.getString("nbairro"));
				i.setCidade(rs.getString("cidade"));
				i.setCep(rs.getString("cep"));
				i.setLocavenda(rs.getBoolean("locavenda"));
				i.setValor(rs.getString("valor"));
				imovel.add(i);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return imovel;
	}
	
	public Imoveis read(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Imoveis i = new Imoveis();

		try {
			stmt = con.prepareStatement("SELECT * FROM imoveis WHERE idImovel=? LIMIT 1;");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				i.setIdImovel(rs.getInt("idImovel"));
				i.setEndereco(rs.getString("endereco"));
				i.setNbairro(rs.getString("nbairro"));
				i.setCidade(rs.getString("cidade"));
				i.setCep(rs.getString("cep"));
				i.setLocavenda(rs.getBoolean("locavenda"));
				i.setValor(rs.getString("valor"));
			}		

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return i;
	}


	public void update(Imoveis i) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE IMOVEL SET endereco=?, nbairro=?, cidade=?,"
					+ "cep=?, locavenda=?, valor=? WHERE idImovel=?;");
			stmt.setString(1, i.getEndereco());
			stmt.setString(2, i.getNbairro());
			stmt.setString(3, i.getCidade());
			stmt.setString(4, i.getCep());    
			stmt.setBoolean(5, i.isLocavenda());
			stmt.setString(6, i.getValor());
			stmt.setInt(7, i.getIdImovel());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Imóvel atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}  

	public void delete(Imoveis i) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM imoveis WHERE idImovel=?");
			stmt.setInt(1, i.getIdImovel());
			stmt.executeUpdate();	
			JOptionPane.showMessageDialog(null, "Imóvel excluído com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
		
}
