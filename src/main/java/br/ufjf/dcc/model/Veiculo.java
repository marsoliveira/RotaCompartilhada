package br.ufjf.dcc.model;

public class Veiculo {

    private String nome;
    private String modelo;
    private String placa;
    private String chassi;
    private int anoFabricacao;
    private String cor;

	private static final int LIM_ANO_FABRICACAO = 2016;

	public Veiculo(String nome, String modelo, String placa, String chassi, int anoFabricacao, String cor) {
		this.nome = nome;
		this.modelo = modelo;
		this.placa = placa;
		this.chassi = chassi;
		if (validarAnoFabricacao(anoFabricacao)) {
			this.anoFabricacao = anoFabricacao;
		}
		this.cor = cor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getChassi() {
		return chassi;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public boolean validarAnoFabricacao(int anoFabricacao) {
		return anoFabricacao >= LIM_ANO_FABRICACAO;
	}

	public void exibirDados() {
		System.out.println("Dados do veículo:");
		System.out.println("Nome: " + this.nome);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Placa: " + this.placa);
		System.out.println("Chassi: " + this.chassi);
		System.out.println("Ano de Fabricação: " + this.anoFabricacao);
		System.out.println("Cor: " + this.cor);
	}
}
