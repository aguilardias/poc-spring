package br.anuncio.bc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anuncio.dao.AnuncioDAO;
import br.anuncio.entity.Anuncio;

@Service
public class AnuncioBC {

	@Autowired
	private AnuncioDAO anuncioDAO;

	public List<Anuncio> listarAnuncio() {
		return anuncioDAO.listarAnuncio();
	}

}
