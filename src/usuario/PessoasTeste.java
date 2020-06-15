package usuario;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.DataTableTeste;

public class PessoasTeste {

	private String nome;
	private String pisPasep;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

	/**
	 * Captura pessoas da base de dados
	 * 
	 * @return String JSON formatada
	 */
	public String getListaPessoas() {
		List<PessoasTeste> lista;
		lista = new DataTableTeste().daoListaPessoas();

		String json = converterListaFormatoJson(lista);

		return json;
	}

	/*
	 * Faz a conversão para padrao JSON
	 */
	private String converterListaFormatoJson(List<PessoasTeste> lista) {

		String json = null;
		JSONObject obj = new JSONObject();
		JSONArray lst = new JSONArray();

		for (PessoasTeste ps : lista) {

			JSONArray array = new JSONArray();
			array.add(ps.getNome());
			array.add(ps.getPisPasep());
			lst.add(array);
			obj.put("data", lst);

		}

		json = obj.toString();
		System.out.println(obj.toString());
		return json;
	}
}
