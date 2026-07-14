package br.ufjf.dcc.model.enums;

public enum StatusCarona {
    AGENDADA("Agendada"),
    EM_ANDAMENTO("Em Andamento"),
    FINALIZADA("Finalizada");

    private final String descricao;

    StatusCarona(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
