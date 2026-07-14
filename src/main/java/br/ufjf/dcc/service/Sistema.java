package br.ufjf.dcc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.ufjf.dcc.model.Carona;
import br.ufjf.dcc.model.Endereco;
import br.ufjf.dcc.model.Motorista;
import br.ufjf.dcc.model.Passageiro;
import br.ufjf.dcc.model.Pessoa;
import br.ufjf.dcc.model.Veiculo;
import br.ufjf.dcc.model.enums.TipoLogradouro;
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

    private static final int LIM_ANO_FABRICACAO = 2016;

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

    private <T extends Pessoa> T selecionarPessoa(List<T> pessoas, String tipoPessoa) {

        if (pessoas.isEmpty()) {
            System.out.println("Nenhum " + tipoPessoa + " cadastrado.");

            return null;
        }

        System.out.println("0. Voltar");
        System.out.println(tipoPessoa + " cadastrados:");

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);

            System.out.println((i + 1) + ". " + pessoa.getNome() + " - CPF: " + pessoa.getCpf());
        }

        int opcao = lerInteiro("Escolha uma opção: ");

        if (opcao == 0) {
            return null;
        }

        if (opcao < 1 || opcao > pessoas.size()) {

            System.out.println(tipoPessoa + " inválido.");

            return null;
        }

        return pessoas.get(opcao - 1);
    }

    private Motorista selecionarMotorista() {
        return selecionarPessoa(this.motoristas, "Motorista");
    }

    private Passageiro selecionarPassageiro() {
        return selecionarPessoa(this.passageiros, "Passageiro");
    }

    public TipoLogradouro escolherTipoLogradouro() {
        System.out.println("1. " + TipoLogradouro.RUA.getDescricao());
        System.out.println("2. " + TipoLogradouro.AVENIDA.getDescricao());
        System.out.println("3. " + TipoLogradouro.ALAMEDA.getDescricao());
        System.out.println("4. " + TipoLogradouro.PRACA.getDescricao());
        System.out.println("5. " + TipoLogradouro.TRAVESSA.getDescricao());
        System.out.println("6. " + TipoLogradouro.RODOVIA.getDescricao());
        System.out.println("7. " + TipoLogradouro.ESTRADA.getDescricao());
        System.out.println("8. " + TipoLogradouro.BECO.getDescricao());
        System.out.println("9. " + TipoLogradouro.BALNEARIO.getDescricao());
        System.out.println("10. " + TipoLogradouro.BOSQUE.getDescricao());
        System.out.println("11. " + TipoLogradouro.CAIS.getDescricao());
        System.out.println("12. " + TipoLogradouro.CALCADA.getDescricao());
        System.out.println("13. " + TipoLogradouro.LARGO.getDescricao());
        System.out.println("14. " + TipoLogradouro.VIADUTO.getDescricao());
        System.out.println("15. " + TipoLogradouro.VIELA.getDescricao());
        System.out.println("16. " + TipoLogradouro.PASSARELA.getDescricao());

        int opcao = lerInteiro("Escolha uma opção: ");

        switch (opcao) {
            case 1 -> {
                return TipoLogradouro.RUA;
            }
            case 2 -> {
                return TipoLogradouro.AVENIDA;
            }
            case 3 -> {
                return TipoLogradouro.ALAMEDA;
            }
            case 4 -> {
                return TipoLogradouro.PRACA;
            }
            case 5 -> {
                return TipoLogradouro.TRAVESSA;
            }
            case 6 -> {
                return TipoLogradouro.RODOVIA;
            }
            case 7 -> {
                return TipoLogradouro.ESTRADA;
            }
            case 8 -> {
                return TipoLogradouro.BECO;
            }
            case 9 -> {
                return TipoLogradouro.BALNEARIO;
            }
            case 10 -> {
                return TipoLogradouro.BOSQUE;
            }
            case 11 -> {
                return TipoLogradouro.CAIS;
            }
            case 12 -> {
                return TipoLogradouro.CALCADA;
            }
            case 13 -> {
                return TipoLogradouro.LARGO;
            }
            case 14 -> {
                return TipoLogradouro.VIADUTO;
            }
            case 15 -> {
                return TipoLogradouro.VIELA;
            }
            case 16 -> {
                return TipoLogradouro.PASSARELA;
            }
            default -> {
                System.out.println("Opção inválida. Escolhendo RUA como padrão.");
                return TipoLogradouro.RUA;
            }
        }
    }

    public void cadastrarMotorista() {
        String nome = lerTexto("Nome: ");
        String cpf = lerTexto("CPF: ");

        TipoLogradouro tipoLogradouro = this.escolherTipoLogradouro();

        String nomeLogradouro = lerTexto("Nome do logradouro: ");
        int numero = lerInteiro("Número: ");
        String bairro = lerTexto("Bairro: ");
        String cidade = lerTexto("Cidade: ");
        String estado = lerTexto("Estado: ");
        String pais = lerTexto("País: ");
        String cep = lerTexto("CEP: ");

        Endereco endereco = new Endereco(tipoLogradouro, nomeLogradouro, numero, bairro, cidade, estado, pais, cep);

        String nomeVeiculo = lerTexto("Nome do veículo: ");
        String modeloVeiculo = lerTexto("Modelo do veículo: ");
        String placaVeiculo = lerTexto("Placa do veículo: ");
        String chassiVeiculo = lerTexto("Chassi do veículo: ");

        int anoFabricacaoVeiculo;

        do {
            anoFabricacaoVeiculo = lerInteiro("Ano de fabricação do veículo: ");

            if (anoFabricacaoVeiculo < LIM_ANO_FABRICACAO) {
                System.out.println("Veículos anteriores a " + LIM_ANO_FABRICACAO + " não podem oferecer caronas.");
            }

        } while (anoFabricacaoVeiculo < LIM_ANO_FABRICACAO);

        String corVeiculo = lerTexto("Cor do veículo: ");

        Veiculo veiculo = new Veiculo(nomeVeiculo, modeloVeiculo, placaVeiculo, chassiVeiculo, anoFabricacaoVeiculo, corVeiculo);

        Motorista motorista = new Motorista(nome, cpf, endereco, veiculo, true);

        this.motoristas.add(motorista);

        System.out.println("Motorista cadastrado com sucesso!");
    }

    public void exibirMotorista() {
        Motorista motorista = this.selecionarMotorista();

        motorista.exibirDados();
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
