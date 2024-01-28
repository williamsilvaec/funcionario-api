package com.williamsilva.funcionarioapi.domain.dto;

import com.williamsilva.funcionarioapi.domain.model.Funcionario;

public class EtiquetaDto {

    private String nome;
    private String email;

    public EtiquetaDto(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.email = funcionario.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
