package br.ufjf.dcc.model;

import br.ufjf.dcc.model.enums.TipoLogradouro;

public class Endereco {

    private TipoLogradouro tipoLogradouro;
    private String nome;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    public Endereco(TipoLogradouro tipoLogradouro, String nome, int numero, String bairro, String cidade, String estado, String pais, String cep) {
        this.tipoLogradouro = tipoLogradouro;
        this.nome = nome;
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

    public void setNomeLogradouro(String nome) {
        this.nome = nome;
    }

    public String getNomeLogradouro() {
        return nome;
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

    public void exibirEndereco() {
        System.out.println("Dados do endereço:");
        System.out.println("Tipo de Logradouro: " + this.tipoLogradouro);
        System.out.println("Nome do Logradouro: " + this.nome);
        System.out.println("Número: " + this.numero);
        System.out.println("Bairro: " + this.bairro);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Estado: " + this.estado);
        System.out.println("País: " + this.pais);
        System.out.println("CEP: " + this.cep);
    }
}
