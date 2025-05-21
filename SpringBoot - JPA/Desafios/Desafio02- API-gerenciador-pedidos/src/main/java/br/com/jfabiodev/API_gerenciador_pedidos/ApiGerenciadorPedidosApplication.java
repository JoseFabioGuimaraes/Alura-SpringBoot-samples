package br.com.jfabiodev.API_gerenciador_pedidos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGerenciadorPedidosApplication implements CommandLineRunner {

	private final TesteDataLoader testeDataLoader;

	public ApiGerenciadorPedidosApplication(TesteDataLoader testeDataLoader) {
		this.testeDataLoader = testeDataLoader;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//testeDataLoader.principal();
	}
}
