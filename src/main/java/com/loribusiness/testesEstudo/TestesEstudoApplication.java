package com.loribusiness.testesEstudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestesEstudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestesEstudoApplication.class, args);
	}

}
// "localhost:8080/h2-console" para entrar no banco de dados
// após isso, ir em JDBC URL e colar "jdbc:h2:mem:testdb"
// apertar em connect
