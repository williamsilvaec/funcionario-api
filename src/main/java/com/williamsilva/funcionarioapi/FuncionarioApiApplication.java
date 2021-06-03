package com.williamsilva.funcionarioapi;

import com.williamsilva.funcionarioapi.domain.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class FuncionarioApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuncionarioApiApplication.class, args);
    }

}
