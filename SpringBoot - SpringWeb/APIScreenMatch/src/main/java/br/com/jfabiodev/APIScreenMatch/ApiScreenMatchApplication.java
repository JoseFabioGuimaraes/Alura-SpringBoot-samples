package br.com.jfabiodev.APIScreenMatch;

import br.com.jfabiodev.APIScreenMatch.main.Main;
import br.com.jfabiodev.APIScreenMatch.repository.SerieRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiScreenMatchApplication{
	public static void main(String[] args) {
		SpringApplication.run(ApiScreenMatchApplication.class, args);
	}
}

