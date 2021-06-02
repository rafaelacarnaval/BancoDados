package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexaoDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "AULA_LP";
	String password = "senha";
	// String driver = "oracle.jdbc.driver.OracleDriver";

	public void inserirRegistro(Profissional p) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, password);
			String q = "INSERT INTO PROFISSIONAL VALUES (?,?,?,?,?)";

			ps = con.prepareStatement(q);

			ps.setString(1, String.valueOf(p.getId()));
			ps.setString(2, p.getNome());
			ps.setString(3, p.getProfissao());
			ps.setString(4, String.valueOf(p.getIdade()));
			ps.setString(5, String.valueOf(p.getSexo()));
			ps.execute();

			System.out.println("Dados inseridos!");
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

	}

	public ArrayList<Profissional> visualizarRegistro(){
		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();

		try {
			con = DriverManager.getConnection(url, user, password);
			String q = "SELECT * FROM PROFISSIONAL";
			ps = con.prepareStatement(q);
			rs = ps.executeQuery();

			while (rs.next()) {
				Profissional prof = new Profissional();
				
				prof.setId(rs.getInt("ID"));
				prof.setNome(rs.getString("NOME"));
				prof.setProfissao(rs.getString("PROFISSAO"));
				prof.setIdade(rs.getString("IDADE"));
				prof.setSexo(rs.getString("SEXO"));
				profissionais.add(prof);
				
				
				/*System.out.println(rs.getInt("ID") + " " + rs.getString("Nome") + " " + rs.getString("Profissao") + " "
						+ rs.getInt("Idade") + " " + rs.getString("Sexo"));*/
			}
			con.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return profissionais;

	}

	public void atualizarRegistro(Profissional p) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, password);
			String q = "UPDATE PROFISSIONAL SET NOME = ?, PROFISSAO = ?, IDADE = ?, SEXO = ? WHERE ID = ?";
			ps = con.prepareStatement(q);

			ps.setString(1, p.getNome());
			ps.setString(2, p.getProfissao());
			ps.setString(3, p.getIdade());
			ps.setString(4, p.getSexo());
			ps.setInt(5, p.getId());
			ps.execute();

			con.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void removerRegistro(Profissional p) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, password);
			String q = "DELETE FROM PROFISSIONAL WHERE ID = ?";
			ps = con.prepareStatement(q);

			ps.setInt(1, p.getId());
			ps.execute();

			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
