package br.com.massuda.alexander.crm.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.massuda.alexander.autenticacao.orm.bo.config.Configuracao;

@SpringBootApplication
@Import({Configuracao.class})
public class ApiUsuarioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiUsuarioApplication.class, args);
	}

}
