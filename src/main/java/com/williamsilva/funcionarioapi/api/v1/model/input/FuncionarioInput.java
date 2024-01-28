package com.williamsilva.funcionarioapi.api.v1.model.input;

import com.williamsilva.funcionarioapi.core.validation.PIS;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FuncionarioInput {

    @NotBlank
    @Size(min = 2, max = 30)
    private String nome;

    @NotBlank
    @Size(min = 2, max = 50)
    private String sobrenome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @PIS
    private String pis;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }
}
