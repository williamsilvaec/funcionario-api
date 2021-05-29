package com.williamsilva.funcionarioapi.domain.repository.spec;

import com.williamsilva.funcionarioapi.domain.filter.FuncionarioFiltro;
import com.williamsilva.funcionarioapi.domain.model.Funcionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class FuncionarioSpec {

    public static Specification<Funcionario> comFiltro(FuncionarioFiltro filtro) {
        return (root, query, builder) -> {

            var predicates = new ArrayList<Predicate>();

            if (filtro.getCodigo() != null) {
                predicates.add(builder.equal(root.get("id"), filtro.getCodigo()));
            }

            if (StringUtils.hasText(filtro.getNome())) {
                String nome = filtro.getNome().toLowerCase();
                predicates.add(builder.like(builder.lower(root.get("nome")), "%" + nome + "%"));
            }

            if (StringUtils.hasText(filtro.getSobrenome())) {
                String sobrenome = filtro.getSobrenome().toLowerCase();
                predicates.add(builder.like(builder.lower(root.get("sobrenome")), "%" + sobrenome + "%"));
            }

            if (StringUtils.hasText(filtro.getPis())) {
                predicates.add(builder.equal(root.get("pis"), filtro.getPis()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
