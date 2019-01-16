package com.promanutencao.ProManutencao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.promanutencao.Repository")
@ComponentScan(basePackages= {"com.promanutencao*"})
@EntityScan(basePackages="com.promanutencao.Model")
@EnableTransactionManagement
public class ProManutencaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProManutencaoApplication.class, args);
	}

}

