package com.williamsilva.funcionarioapi.domain.repository;

import com.williamsilva.funcionarioapi.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FuncionarioRepository extends CustomJpaRepository<Funcionario, Integer>,
        JpaSpecificationExecutor<Funcionario> {

    Optional<Funcionario> findByPis(String pis);
}
