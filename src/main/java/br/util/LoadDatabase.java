package br.util;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.anuncio.bc.AnuncioBC;
import br.anuncio.dao.AnuncioDAO;

@Configuration
public class LoadDatabase {

	Logger logger = Logger.getLogger(LoadDatabase.class.getName());

	@Autowired
	AnuncioBC anuncioBC;

	@Bean
	CommandLineRunner initDatabase(AnuncioDAO anuncioDAO) {
		return args -> {
			UUID randomUUID = UUID.randomUUID();
			// logger.info("gerando anuncio: " + randomUUID);
			// anuncioDAO.salvar(new Anuncio("teste: " + randomUUID));
		};
	}
}
