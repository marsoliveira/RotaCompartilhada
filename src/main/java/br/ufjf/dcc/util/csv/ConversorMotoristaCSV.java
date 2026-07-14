package br.ufjf.dcc.util.csv;

import br.ufjf.dcc.model.Endereco;
import br.ufjf.dcc.model.Motorista;
import br.ufjf.dcc.model.Veiculo;
import br.ufjf.dcc.model.enums.TipoLogradouro;

public class ConversorMotoristaCSV implements ConversorCSV<Motorista> {

    @Override
    public Motorista converter(String linha) {

        String[] dados = linha.split("[,\t]");

        String nome = dados[0];
        String cpf = dados[1];
        boolean disponivel = Boolean.parseBoolean(dados[16]);

        Endereco endereco = new Endereco(
                TipoLogradouro.converterTipoLogradouroParaString(dados[2]), // tipo_logradouro
                dados[3], // nome_logradouro
                Integer.parseInt(dados[4]), // numero
                dados[5], // bairro
                dados[6], // cidade
                dados[7], // estado
                dados[8], // pais
                dados[9] // cep
        );

        Veiculo veiculo = new Veiculo(
                dados[10], // nome
                dados[11], // modelo
                dados[12], // placa
                dados[13], // chassi
                Integer.parseInt(dados[14]), // ano
                dados[15] // cor
        );

        return new Motorista(nome, cpf, endereco, veiculo, disponivel);
    }
}
