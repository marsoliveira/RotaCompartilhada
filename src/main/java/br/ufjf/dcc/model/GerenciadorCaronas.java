package br.ufjf.dcc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.ufjf.dcc.model.enums.StatusCarona;

public class GerenciadorCaronas {

    private List<Carona> caronasAgendadas;
    private List<Carona> caronasEmAndamento;
    private List<Carona> caronasFinalizadas;

    public GerenciadorCaronas() {
        this.caronasAgendadas = new ArrayList<>();
        this.caronasEmAndamento = new ArrayList<>();
        this.caronasFinalizadas = new ArrayList<>();
    }

    public List<Carona> getCaronasAgendadas() {
        return this.caronasAgendadas;
    }

    public List<Carona> getCaronasEmAndamento() {
        return this.caronasEmAndamento;
    }

    public List<Carona> getCaronasFinalizadas() {
        return this.caronasFinalizadas;
    }

    public boolean existeConflito(LocalDateTime inicio1, LocalDateTime fim1, LocalDateTime inicio2, LocalDateTime fim2) {
        return inicio1.isBefore(fim2) && fim1.isAfter(inicio2);
    }

    public boolean passageiroDisponivel(Passageiro passageiro, LocalDateTime inicio, LocalDateTime fim) {
        for (Carona carona : this.caronasAgendadas) {
            if (carona.getPassageiro().equals(passageiro) && existeConflito(inicio, fim, carona.getInicio(), carona.getFim())) {
                return false;
            }
        }

        for (Carona carona : this.caronasEmAndamento) {
            if (carona.getPassageiro().equals(passageiro) && existeConflito(inicio, fim, carona.getInicio(), carona.getFim())) {

                return false;
            }
        }

        return true;
    }

    public boolean motoristaDisponivel(Motorista motorista, LocalDateTime inicio, LocalDateTime fim) {
        if (!motorista.estaDisponivel()) {
            return false;
        }

        for (Carona carona : this.caronasAgendadas) {

            if (carona.getMotorista().equals(motorista) && existeConflito(inicio, fim, carona.getInicio(), carona.getFim())) {
                return false;
            }
        }

        for (Carona carona : this.caronasEmAndamento) {

            if (carona.getMotorista().equals(motorista) && existeConflito(inicio, fim, carona.getInicio(), carona.getFim())) {
                return false;
            }
        }

        return true;
    }

    public Motorista sortearMotorista(List<Motorista> motoristas, LocalDateTime inicio, LocalDateTime fim) {
        List<Motorista> disponiveis = new ArrayList<>();

        for (Motorista motorista : motoristas) {
            if (motoristaDisponivel(motorista, inicio, fim)) {
                disponiveis.add(motorista);
            }
        }

        if (disponiveis.isEmpty()) {
            return null;
        }

        Random random = new Random();

        int indice = random.nextInt(disponiveis.size());

        return disponiveis.get(indice);
    }

    public void cadastrarCarona(Passageiro passageiro, Endereco origem, Endereco destino, List<Motorista> motoristas) {
        LocalDateTime inicio = LocalDateTime.now();

        Random random = new Random();

        int horas = random.nextInt(3) + 1;

        LocalDateTime fim = inicio.plusHours(horas);

        if (!passageiroDisponivel(passageiro, inicio, fim)) {
            System.out.println("Passageiro possui conflito de horário.");

            return;
        }

        Motorista motorista = sortearMotorista(motoristas, inicio, fim);

        if (motorista == null) {
            System.out.println("Nenhum motorista disponível.");

            return;
        }

        Carona carona = new Carona(motorista, passageiro, origem, destino, inicio, fim);

		carona.setStatus(StatusCarona.EM_ANDAMENTO);

        this.caronasEmAndamento.add(carona);
    }

    public void agendarCarona(Passageiro passageiro, Endereco origem, Endereco destino, LocalDateTime inicioEscolhido, List<Motorista> motoristas) {
        if (inicioEscolhido.isBefore(LocalDateTime.now())) {
            System.out.println("A data precisa ser futura.");

            return;
        }

        Random random = new Random();

        int horas = random.nextInt(3) + 1;

        LocalDateTime fim = inicioEscolhido.plusHours(horas);

        if (!passageiroDisponivel(passageiro, inicioEscolhido, fim)) {
            System.out.println("Conflito encontrado.");

            return;
        }

        Motorista motorista = sortearMotorista(motoristas, inicioEscolhido, fim);

        if (motorista == null) {
            System.out.println("Nenhum motorista disponível.");

            return;
        }

        Carona carona = new Carona(motorista, passageiro, origem, destino, inicioEscolhido, fim);

		carona.setStatus(StatusCarona.AGENDADA);

        caronasAgendadas.add(carona);
    }

    public void listarCaronas(List<Carona> caronas) {
        if (caronas == null || caronas.isEmpty()) {
            System.out.println("Nenhuma carona cadastrada.");

            return;
        }

		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Carona carona : caronas) {
            System.out.println("Motorista: " + carona.getMotorista().getNome());
            System.out.println("Passageiro: " + carona.getPassageiro().getNome());
            System.out.println("Origem: " + carona.getOrigem().toString());
            System.out.println("Destino: " + carona.getDestino().toString());
            System.out.println("Início: " + carona.getInicio().format(dataFormatada));
            System.out.println("Fim: " + carona.getFim().format(dataFormatada));
            System.out.println("Status: " + carona.getStatus().getDescricao());
        }
    }
}
