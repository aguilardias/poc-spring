package br.init;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.anuncio.bc.AnuncioBC;
import br.anuncio.entity.Anuncio;

@Configuration
public class LoadDatabase implements CommandLineRunner {

	Logger logger = Logger.getLogger(LoadDatabase.class.getName());

	@Autowired
	AnuncioBC anuncioBC;

	@Override
	public void run(String... args) throws Exception {
		UUID randomUUID = UUID.randomUUID();
		logger.info("gerando anuncio: " + randomUUID);
		anuncioBC.salvar(new Anuncio("teste: " + randomUUID));
	}

}
