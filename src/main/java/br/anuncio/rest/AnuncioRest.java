package br.anuncio.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.anuncio.bc.AnuncioBC;
import br.anuncio.entity.Anuncio;
import br.anuncio.exception.NegocioException;

@RestController
@RequestMapping("anuncio")
public class AnuncioRest {

	@Autowired
	private AnuncioBC anuncioBC;

	Logger logger = Logger.getLogger(AnuncioRest.class.getName());

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Anuncio> listarAnuncio() {
		return anuncioBC.listarAnuncio();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Anuncio anuncio(@PathVariable("id") Long id) {
		return anuncioBC.obterAnuncio(id).orElseThrow(() -> new NegocioException("não existe"));
	}
}
