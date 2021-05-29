package com.williamsilva.funcionarioapi.api.exceptionhandler;

public enum ProblemType {

    RECURSO_NAO_ENCONTRADO("Recurso não encontrado"),
    DADOS_INVALIDOS("Dados inválidos"),
    PARAMETRO_INVALIDO("Parâmetro inválido"),
    ERRO_DE_SISTEMA("Erro de sistema"),
    ERRO_NEGOCIO("Violação de regra de negócio");


    private String title;

    ProblemType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
