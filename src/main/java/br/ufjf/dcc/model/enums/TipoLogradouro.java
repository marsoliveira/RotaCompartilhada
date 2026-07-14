package br.ufjf.dcc.model.enums;

public enum TipoLogradouro {
    RUA("Rua"),
    AVENIDA("Avenida"),
    ALAMEDA("Alameda"),
    PRACA("Praça"),
    TRAVESSA("Travessa"),
    RODOVIA("Rodovia"),
    ESTRADA("Estrada"),
    BECO("Beco"),
    BALNEARIO("Balneário"),
    BOSQUE("Bosque"),
    CAIS("Cais"),
    CALCADA("Calçada"),
    LARGO("Largo"),
    VIADUTO("Viaduto"),
    VIELA("Viela"),
    PASSARELA("Passarela");

	private final String descricao;

    TipoLogradouro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
