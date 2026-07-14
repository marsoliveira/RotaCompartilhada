package br.ufjf.dcc.model;

public class Motorista extends Pessoa {

    private Veiculo veiculo;
    private boolean disponivel;

    public Motorista(String nome, String cpf, Endereco endereco, Veiculo veiculo) {
        super(nome, cpf, endereco);
        this.veiculo = veiculo;
        this.disponivel = true;
    }

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean estaDisponivel() {
		return disponivel;
	}
}
