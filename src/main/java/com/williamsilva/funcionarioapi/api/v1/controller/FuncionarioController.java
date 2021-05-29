package com.williamsilva.funcionarioapi.api.v1.controller;

import com.williamsilva.funcionarioapi.api.v1.model.FuncionarioModel;
import com.williamsilva.funcionarioapi.api.v1.model.input.FuncionarioInput;
import com.williamsilva.funcionarioapi.domain.filter.FuncionarioFiltro;
import com.williamsilva.funcionarioapi.domain.model.Funcionario;
import com.williamsilva.funcionarioapi.domain.service.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final ModelMapper modelMapper;

    public FuncionarioController(FuncionarioService funcionarioService, ModelMapper modelMapper) {
        this.funcionarioService = funcionarioService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public Page<FuncionarioModel> filtrar(FuncionarioFiltro filtro, Pageable pageable) {
        Page<Funcionario> page = funcionarioService.filtrar(filtro, pageable);
        List<FuncionarioModel> funcionarios = toCollectionModel(page.getContent());

        return new PageImpl<>(funcionarios, pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public FuncionarioModel buscar(@PathVariable Integer id) {
        Funcionario funcionario = funcionarioService.buscarOuFalhar(id);
        return toModel(funcionario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioModel criar(@RequestBody @Valid FuncionarioInput funcionarioInput) {
        Funcionario funcionario = toEntity(funcionarioInput);

        funcionario = funcionarioService.salvar(funcionario);

        return toModel(funcionario);
    }

    @PutMapping("/{id}")
    public FuncionarioModel atualizar(@PathVariable Integer id,
                 @RequestBody @Valid FuncionarioInput funcionarioInput) {
        Funcionario funcionario = funcionarioService.buscarOuFalhar(id);

        BeanUtils.copyProperties(funcionarioInput, funcionario);

        funcionario = funcionarioService.salvar(funcionario);

        return toModel(funcionario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        funcionarioService.excluir(id);
    }

    private Funcionario toEntity(FuncionarioInput funcionarioInput) {
        return modelMapper.map(funcionarioInput, Funcionario.class);
    }

    private FuncionarioModel toModel(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioModel.class);
    }

    private List<FuncionarioModel> toCollectionModel(List<Funcionario> lista) {
        return lista.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
