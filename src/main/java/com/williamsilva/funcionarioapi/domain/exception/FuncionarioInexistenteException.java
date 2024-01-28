package com.williamsilva.funcionarioapi.domain.exception;

public class FuncionarioInexistenteException extends EntidadeNaoEncontradaException {

    public FuncionarioInexistenteException(Integer id) {
        super(String.format("Funcionário de código %d não encontrado", id));
    }
}
