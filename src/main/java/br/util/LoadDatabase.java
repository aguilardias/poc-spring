package br.util;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.anuncio.bc.AnuncioBC;
import br.anuncio.dao.AnuncioDAO;
import br.anuncio.entity.Anuncio;

@Configuration
public class LoadDatabase {

	Logger logger = Logger.getLogger(LoadDatabase.class.getName());

	@Autowired
	AnuncioBC anuncioBC;

	@Bean
	CommandLineRunner initDatabase(AnuncioDAO anuncioDAO) {
		return args -> {
			anuncioDAO.inserir(new Anuncio(1L, "teste1"));
			logger.info("Preloading 1");
		};
	}
}
