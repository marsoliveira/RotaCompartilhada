package br.ufjf.dcc.model;

import java.time.LocalDateTime;

import br.ufjf.dcc.model.enums.StatusCarona;

public class Carona {

    private Motorista motorista;
    private Passageiro passageiro;
    private Endereco origem;
    private Endereco destino;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private StatusCarona status;

	public Carona(Motorista motorista, Passageiro passageiro, Endereco origem, Endereco destino, LocalDateTime inicio, LocalDateTime fim) {
		this.motorista = motorista;
		this.passageiro = passageiro;
		this.origem = origem;
		this.destino = destino;
		this.inicio = inicio;
		this.fim = fim;
		this.status = StatusCarona.AGENDADA;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setOrigem(Endereco origem) {
		this.origem = origem;
	}

	public Endereco getOrigem() {
		return origem;
	}

	public void setDestino(Endereco destino) {
		this.destino = destino;
	}

	public Endereco getDestino() {
		return destino;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setStatus(StatusCarona status) {
		this.status = status;
	}

	public StatusCarona getStatus() {
		return status;
	}
}
