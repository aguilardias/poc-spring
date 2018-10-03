package br.anuncio.rs;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.anuncio.bc.AnuncioBC;
import br.anuncio.entity.Anuncio;

@RestController
@RequestMapping("anuncio")
public class AnuncioRest {

	@Autowired
	private AnuncioBC anuncioBC;

	Logger logger = Logger.getLogger(AnuncioRest.class.getName());

	@RequestMapping(method = RequestMethod.GET, value = "lista")
	public List<Anuncio> listarAnuncio() {
		return anuncioBC.listarAnuncio();
	}

	@RequestMapping(method = RequestMethod.GET, value = "lista-banco")
	public Iterable<Anuncio> listarAnuncioBanco() {
		return anuncioBC.listarAnuncioBanco();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Anuncio anuncio(@PathVariable("id") int id) {
		// anuncioBC.obterAnuncio(id)
		logger.info("ID: " + id);
		return new Anuncio(1L, "");
	}
}
