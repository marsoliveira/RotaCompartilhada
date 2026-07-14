package br.ufjf.dcc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufjf.dcc.model.Carona;
import br.ufjf.dcc.model.Motorista;
import br.ufjf.dcc.model.Passageiro;
import br.ufjf.dcc.util.csv.ConversorMotoristaCSV;
import br.ufjf.dcc.util.csv.LeitorCSV;

public class Sistema {

    private List<Motorista> motoristas;
    private List<Passageiro> passageiros;
    private List<Carona> agendadas;
    private List<Carona> emAndamento;
    private List<Carona> finalizadas;

    public Sistema() {

        try {
            motoristas = LeitorCSV.carregar("src/maim/resources/motoristas.csv", new ConversorMotoristaCSV());
        } catch (IOException e) {
            System.out.println("Erro ao carregar motoristas: " + e.getMessage());

            motoristas = new ArrayList<>();
        }
    }

    public void cadastrarMotorista() {

    }

    public void exibirMotorista() {

    }

    public void editarMotorista() {

    }

    public void removerMotorista() {

    }

    public void listarMotoristas() {

    }

    public void cadastrarPassageiro() {

    }

    public void exibirPassageiro() {

    }

    public void editarPassageiro() {

    }

    public void removerPassageiro() {

    }

    public void listarPassageiros() {

    }

    public void cadastrarCarona() {

    }

    public void agendarCarona() {

    }

    // public boolean verificarStatusCarona() {
    // }
    public void finalizarCarona() {
    }

    public void listarCaronasAgendadas() {

    }

    public void listarCaronasEmAndamento() {

    }

    public void listarCaronasFinalizadas() {

    }

    public void atualizarSistema() {

    }
}
