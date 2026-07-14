package br.ufjf.dcc.model;

public class Pessoa {

    private String nome;
    private String cpf;
    private Endereco endereco;

	public Pessoa(String nome, String cpf, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void exibirDados() {
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		endereco.exibirEndereco();
	}
}
