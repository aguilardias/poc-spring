package br.anuncio.bc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anuncio.dao.AnuncioDAO;
import br.anuncio.entity.Anuncio;

@Service
public class AnuncioBC {

	@Autowired
	private AnuncioDAO anuncioDAO;

	public Iterable<Anuncio> listarAnuncio() {
		return anuncioDAO.listarAnuncio();
	}

	public Optional<Anuncio> obterAnuncio(Long id) {
		return anuncioDAO.obterAnuncio(id);
	}

}
