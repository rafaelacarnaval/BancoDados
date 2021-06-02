package bd;

import java.sql.SQLException;

public class Profissional {
	
	private int id;
	private String nome;
	private String profissao;
	private String idade;
	private String sexo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "ID " + this.getId() + " da pessoa " + this.getNome() + " de profissão " + this.getProfissao()
		+ " e idade " + this.getIdade() + " do sexo " + this.getSexo() + "\n";
	}
	/*public static void main(String[] args) {
		Profissional p = new Profissional();
		ConexaoDAO conexaodao = new ConexaoDAO();
		
		p.setId(4);
		p.setNome("Gabriela da Silva");
		p.setProfissao("Assistente Administrativa");
		p.setIdade(32);
		p.setSexo("F");
		
		try {
			conexaodao.inserirRegistro(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
