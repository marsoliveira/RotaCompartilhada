package br.ufjf.dcc.model;

import br.ufjf.dcc.model.enums.TipoLogradouro;

public class Endereco {

    private TipoLogradouro tipoLogradouro;
	private String nomeLogradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;

	public Endereco(TipoLogradouro tipoLogradouro, String nomeLogradouro, int numero, String bairro, String cidade, String estado, String pais, String cep) {
		this.tipoLogradouro = tipoLogradouro;
		this.nomeLogradouro = nomeLogradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}
}
