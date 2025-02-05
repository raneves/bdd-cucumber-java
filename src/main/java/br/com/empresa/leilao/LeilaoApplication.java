package br.com.empresa.leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeilaoApplication {

	//adicionar o parametro, em Arqguments, VM arguments, ao executar o projeto, rum as, e adicionar o profile como test
	//-Dspring.profiles.active=test
	//-Dbrowser=firefox
	
	
	//executar localhost:8080 para mostrar a pagina padrao
	
	//http://localhost:8080/h2-console
	
	//rodar http://localhost:8080/db/seed para popular o banco teste
	
	//usuarios criados estao em DBController.java, exemplo fulano.....
	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}
	
}
