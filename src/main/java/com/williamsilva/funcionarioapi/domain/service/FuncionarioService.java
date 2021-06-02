package com.williamsilva.funcionarioapi.domain.service;

import com.williamsilva.funcionarioapi.domain.exception.EntidadeEmUsoException;
import com.williamsilva.funcionarioapi.domain.exception.FuncionarioInexistenteException;
import com.williamsilva.funcionarioapi.domain.exception.NegocioException;
import com.williamsilva.funcionarioapi.domain.filter.FuncionarioFiltro;
import com.williamsilva.funcionarioapi.domain.model.Funcionario;
import com.williamsilva.funcionarioapi.domain.repository.FuncionarioRepository;
import com.williamsilva.funcionarioapi.domain.repository.spec.FuncionarioSpec;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario buscarOuFalhar(Integer funcionarioId) {
        return funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new FuncionarioInexistenteException(funcionarioId));
    }

    @Transactional
    public Funcionario salvar(Funcionario funcionario) {
        if (!funcionario.isNovo()) {
            return funcionarioRepository.save(funcionario);
        }

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByPis(funcionario.getPis());

        if (funcionarioOptional.isPresent()) {
            throw new NegocioException(String.format("Já existe um funcionário com o PIS %s cadastrado",
                    funcionario.getPis()));
        }

        return funcionarioRepository.save(funcionario);
    }

    public Page<Funcionario> filtrar(FuncionarioFiltro filtro, Pageable pageable) {
        return funcionarioRepository.findAll(FuncionarioSpec.comFiltro(filtro), pageable);
    }

    @Transactional
    public void excluir(Integer id) {
        try {
            funcionarioRepository.deleteById(id);
            funcionarioRepository.flush();

        } catch (EmptyResultDataAccessException ex) {
            throw new FuncionarioInexistenteException(id);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Funcionário de código %d não pode ser excluído," +
                    " pois está em uso", id));
        }
    }
}
