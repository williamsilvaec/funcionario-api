package com.williamsilva.funcionarioapi.domain.repository;

import com.williamsilva.funcionarioapi.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>,
        JpaSpecificationExecutor<Funcionario> {

    Optional<Funcionario> findByPis(String pis);
}
