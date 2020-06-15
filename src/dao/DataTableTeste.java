package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import usuario.PessoasTeste;

public class DataTableTeste {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement prs;
	
	public List<PessoasTeste> daoListaPessoas(){
		List<PessoasTeste>lista = new ArrayList<PessoasTeste>();
		String sql = "select * from prefeitura.tb_pessoas";
		
		try {
			new Conexao();
			con = Conexao.getconection();
			prs = con.prepareStatement(sql);
			rs = prs.executeQuery();
			
			while(rs.next()) {
				PessoasTeste pessoa = new PessoasTeste();
				pessoa.setNome(rs.getString("nome"));
				pessoa.setPisPasep(rs.getString("pis_pasep"));
				lista.add(pessoa);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
}
