package br.ufjf.dcc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
    private boolean executando;
    private Scanner leitor = new Scanner(System.in);

    public Sistema() {
        this.motoristas = new ArrayList<>();
        this.passageiros = new ArrayList<>();
        this.agendadas = new ArrayList<>();
        this.emAndamento = new ArrayList<>();
        this.finalizadas = new ArrayList<>();
        this.executando = true;

        try {
            motoristas = LeitorCSV.carregar("src/main/resources/motoristas.csv", new ConversorMotoristaCSV());
        } catch (IOException e) {
            System.out.println("Erro ao carregar motoristas: " + e.getMessage());

            motoristas = new ArrayList<>();
        }
    }

    private void exibirMenu() {
        System.out.println("MENU");
        System.out.println("1. Cadastrar Motorista");
        System.out.println("2. Exibir Motorista");
        System.out.println("3. Editar Motorista");
        System.out.println("4. Remover Motorista");
        System.out.println("5. Listar Motoristas");
        System.out.println("6. Cadastrar Passageiro");
        System.out.println("7. Exibir Passageiro");
        System.out.println("8. Editar Passageiro");
        System.out.println("9. Remover Passageiro");
        System.out.println("10. Listar Passageiros");
        System.out.println("11. Cadastrar Carona");
        System.out.println("12. Agendar Carona");
        System.out.println("13. Finalizar Carona");
        System.out.println("14. Verificar Status da Carona");
        System.out.println("15. Listar Caronas Agendadas");
        System.out.println("16. Listar Caronas em Andamento");
        System.out.println("17. Listar Caronas Finalizadas");
        System.out.println("18. Encerrar Sistema");
    }

    public void iniciar() {
        while (executando) {

            this.exibirMenu();

            int opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1 ->
                    this.cadastrarMotorista();

                case 2 ->
                    this.exibirMotorista();

                case 3 ->
                    this.editarMotorista();

                case 4 ->
                    this.removerMotorista();

                case 5 ->
                    this.listarMotoristas();

                case 6 ->
                    this.cadastrarPassageiro();

                case 7 ->
                    this.exibirPassageiro();

                case 8 ->
                    this.editarPassageiro();

                case 9 ->
                    this.removerPassageiro();

                case 10 ->
                    this.listarPassageiros();

                case 11 ->
                    this.cadastrarCarona();

                case 12 ->
                    this.agendarCarona();

                case 13 ->
                    this.finalizarCarona();

                case 14 ->
                    this.verificarStatusCarona();

                case 15 ->
                    this.listarCaronasAgendadas();

                case 16 ->
                    this.listarCaronasEmAndamento();

                case 17 ->
                    this.listarCaronasFinalizadas();

                case 18 ->
                    this.encerrarSistema();

                default ->
                    System.out.println("Opção inválida.");
            }
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {

            try {

                System.out.print(mensagem);

                int valor = leitor.nextInt();
                leitor.nextLine();

                return valor;

            } catch (InputMismatchException e) {

                System.out.println("Entrada inválida. Digite um número inteiro.");
                leitor.nextLine();
            }
        }
    }

    private String lerTexto(String mensagem) {
        String texto;

        do {

            System.out.print(mensagem);

            texto = leitor.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Texto inválido.");
            }

        } while (texto.isEmpty());

        return texto;
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

    public boolean verificarStatusCarona() {
        return false;
    }

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

    public void encerrarSistema() {
        System.out.println("Encerrando sistema...");

        executando = false;

        leitor.close();
    }
}
