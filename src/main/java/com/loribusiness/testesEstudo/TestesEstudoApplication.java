package com.loribusiness.testesEstudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestesEstudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestesEstudoApplication.class, args);
	}

}
/* Lá no postman quando procurar um order, ele carregará consigo um user,
mas não ocorre o inverso, o user não carrega orders.
Isso pois o user é a parte que tem vários e isso ia capotar a memória do PC.

Nome dessa "poupança" de memória: Lazy Loading.

Razão disso ocorrer: o @JsonIgnore la em User, se esse @ fosse no Order aconteceria o inverso,
o user que iria exibir orders, e o order nadica de user.
*/
