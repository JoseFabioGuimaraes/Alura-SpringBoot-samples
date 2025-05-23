package br.com.jfabiodev.MusicGem;

import br.com.jfabiodev.MusicGem.principal.Principal;
import br.com.jfabiodev.MusicGem.repository.ArtistaRepository;
import br.com.jfabiodev.MusicGem.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicGemApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository artistaRepository;

	@Autowired
	private MusicaRepository musicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(MusicGemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistaRepository, musicaRepository);
		principal.exibeMenu();
	}
}
