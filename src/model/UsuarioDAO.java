package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

	public boolean inserirUsuario(Usuario usuario) {

		Connection conn;
		try {

			conn = ConexaoBD.conexaoMySql();
			String query = "INSERT INTO usuario VALUES(NULL,?,?)";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, usuario.getNome());
			pstm.setInt(2, usuario.getIdade());
			pstm.executeUpdate();
			return true;

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			return false;
			
		}

	}

	public String getNomeByID(int id) {

		Connection conn;
		try {
			
			conn = ConexaoBD.conexaoMySql();
			String query = "SELECT nome FROM usuario WHERE ID =?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			String nome = "";

			if (rs.next()) {

				nome = rs.getString(1);

			}

			pstm.close();
			conn.close();

			return nome;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "";
		}


	}

	public ArrayList<Usuario> getListaUsuarios(){

		Connection conn;
		
		try {
			
			conn = ConexaoBD.conexaoMySql();
			String query = "SELECT * FROM usuario";
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			ArrayList<Usuario> usuarios = new ArrayList<>();

			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt(1));
				user.setNome(rs.getString(2));
				user.setIdade(rs.getInt(3));
				usuarios.add(user);
			}

			pstm.close();
			conn.close();
			
			return usuarios;
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			return null;
			
		}

	}

	public Usuario getUsuarioPorID(int id) {

		Connection conn;
		try {
			conn = ConexaoBD.conexaoMySql();
			String query = "SELECT * FROM usuario WHERE ID = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Usuario user = new Usuario();
			
			if (rs.next()) {

				user.setId(rs.getInt(1));
				user.setNome(rs.getString(2));
				user.setIdade(rs.getInt(3));
				
			}

			pstm.close();
			conn.close();
			
			return user;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
